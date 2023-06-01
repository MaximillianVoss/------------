import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Matrix {
    private double[][] m;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        m = new double[rows][cols];
    }

    public void readFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String[] dimensions = br.readLine().trim().split(" ");
            rows = Integer.parseInt(dimensions[0]);
            cols = Integer.parseInt(dimensions[1]);

            m = new double[rows][cols];

            for (int i = 0; i < rows; i++) {
                String[] row = br.readLine().trim().split(" ");
                for (int j = 0; j < cols; j++) {
                    m[i][j] = Double.parseDouble(row[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void triangularForm() {
        for (int i = 0; i < rows - 1; i++) {
            for (int j = i + 1; j < rows; j++) {
                double factor = m[j][i] / m[i][i];
                for (int k = i; k < cols; k++) {
                    m[j][k] -= factor * m[i][k];
                }
            }
        }
    }

    private boolean checkSolutions() {
        for (int i = 0; i < rows; i++) {
            boolean allZeros = true;
            for (int j = 0; j < cols - 1; j++) {
                if (m[i][j] != 0) {
                    allZeros = false;
                    break;
                }
            }
            if (allZeros && m[i][cols - 1] != 0) {
                return false;
            }
        }
        return true;
    }

    public double[] solve() {
        triangularForm();

        if (!checkSolutions()) {
            System.out.println("Система не имеет решений");
            return null;
        }

        double[] solution = new double[rows];
        for (int i = rows - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < cols - 1; j++) {
                sum += m[i][j] * solution[j];
            }
            solution[i] = (m[i][cols - 1] - sum) / m[i][i];
        }
        return solution;
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%10.2f", m[i][j]);
            }
            System.out.println();
        }
    }

    public void printSolution() {
        double[] solution = solve();
        if (solution != null) {
            System.out.println("Решение системы уравнений:");
            for (int i = 0; i < solution.length; i++) {
                System.out.printf("x%d = %.2f\n", i + 1, solution[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String filename = "input.txt"; // Укажите здесь путь к вашему файлу с матрицей и вектором констант
        Matrix matrix = new Matrix(0, 0);
        matrix.readFromFile(filename);
        System.out.println("Исходная система уравнений:");
        matrix.print();
        matrix.printSolution();
    }
}
