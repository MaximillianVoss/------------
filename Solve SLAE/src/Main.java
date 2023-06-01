import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Main {

    public static void main(String[] args) {
        // Выбор файла с СЛАУ с помощью диалогового окна
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String filename = fileChooser.getSelectedFile().getAbsolutePath();

        // Чтение СЛАУ из файла
        double[][] A = null;
        double[] b = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            String[] values = line.split(" ");
            int n = Integer.parseInt(values[0]);
            int m = Integer.parseInt(values[1]);
            A = new double[n][m];
            b = new double[n];
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                values = line.split(" ");
                for (int j = 0; j < m; j++) {
                    A[i][j] = Double.parseDouble(values[j]);
                }
                b[i] = Double.parseDouble(values[m]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Решение СЛАУ методом Гаусса
        double[] x = GaussMethod.solve(A, b);

        // Вывод исходной СЛАУ
        System.out.println("Исходная система:");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.printf("%.6f ", A[i][j]);
            }
            System.out.printf("| %.6f\n", b[i]);
        }

        // Вывод СЛАУ в треугольном виде
        System.out.println("Система в треугольном виде:");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.printf("%.6f ", A[i][j]);
            }
            System.out.printf("| %.6f\n", b[i]);
        }

        // Вывод решения СЛАУ
        System.out.println("Решение:");
        if (x != null) {
            for (int i = 0; i < x.length; i++) {
                System.out.printf("x%d = %.6f\n", i+1, x[i]);
            }
        }
    }
}
