import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

class Matrix {
    private double[][] data;
    private double[] constants;
    private double[] solution;

    public Matrix(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int n = scanner.nextInt();
            data = new double[n][n];
            constants = new double[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    data[i][j] = scanner.nextDouble();
                }
                constants[i] = scanner.nextDouble();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double[] solve() {
        int n = data.length;
        double[] x = new double[n];
        double[] prevX = new double[n];
        double eps = 1e-6;
        int maxIterations = 1000;

        for (int k = 0; k < maxIterations; k++) {
            System.arraycopy(x, 0, prevX, 0, n);

            for (int i = 0; i < n; i++) {
                double sum = constants[i];

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum -= data[i][j] * prevX[j];
                    }
                }

                x[i] = sum / data[i][i];
            }

            double maxDiff = Math.abs(x[0] - prevX[0]);

            for (int i = 1; i < n; i++) {
                double diff = Math.abs(x[i] - prevX[i]);
                if (diff > maxDiff) {
                    maxDiff = diff;
                }
            }

            if (maxDiff < eps) {
                break;
            }
        }

        solution = x;
        return solution;
    }

    public void printSystem() {
        DecimalFormat df = new DecimalFormat("0.000000E0");

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(df.format(data[i][j]) + " ");
            }
            System.out.println("= " + df.format(constants[i]));
        }
    }

    public void printSolution() {
        if (solution != null) {
            DecimalFormat df = new DecimalFormat("0.000000E0");

            for (int i = 0; i < solution.length; i++) {
                System.out.println("x" + (i + 1) + " = " + df.format(solution[i]));
            }
        } else {
            System.out.println("No solution found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix("data.txt");

        matrix.printSystem();
        double[] solution = matrix.solve();
        matrix.printSolution();
    }
}
