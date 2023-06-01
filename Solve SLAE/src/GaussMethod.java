
//TODO: вставить чтение из файла в этот класс
//TODO: убрать вывод решений в main
public class GaussMethod {
    // Метод для решения СЛАУ методом Гаусса
    public static double[] solve(double[][] A, double[] b) {
        int n = A.length; // Количество уравнений
        int m = A[0].length; // Количество неизвестных
        double[][] Ab = new double[n][m + 1]; // Матрица коэффициентов и вектор правых частей
        double[] x = new double[m]; // Вектор решений
        boolean[] usedRows = new boolean[n]; // Массив для отметки использованных строк

        // Заполнение матрицы коэффициентов и вектора правых частей
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Ab[i][j] = A[i][j];
            }
            Ab[i][m] = b[i];
        }

        // Прямой ход метода Гаусса
        for (int j = 0; j < m; j++) {
            // Находим максимальный элемент в j-ом столбце и меняем строки местами
            int maxRow = j;
            for (int i = j + 1; i < n; i++) {
                if (Math.abs(Ab[i][j]) > Math.abs(Ab[maxRow][j])) {
                    maxRow = i;
                }
            }
            if (maxRow != j) {
                double[] temp = Ab[j];
                Ab[j] = Ab[maxRow];
                Ab[maxRow] = temp;
            }
            // Обнуляем j-ый столбец ниже j-ой строки
            if (Ab[j][j] != 0) {
                for (int i = j + 1; i < n; i++) {
                    double factor = Ab[i][j] / Ab[j][j];
                    for (int k = j; k <= m; k++) {
                        Ab[i][k] -= factor * Ab[j][k];
                    }
                }
            }
        }

        // Обратный ход метода Гаусса
        for (int j = m - 1; j >= 0; j--) {
            if (Ab[j][j] != 0) {
                x[j] = Ab[j][m] / Ab[j][j];
                for (int i = 0; i < j; i++) {
                    Ab[i][m] -= Ab[i][j] * x[j];
                    Ab[i][j] = 0;
                }
            } else {
                x[j] = 0;
            }
        }

        // Проверяем возможность решения СЛАУ
        int rank = 0;
        for (int i = 0; i < n; i++) {
            boolean allZeroes = true;
            for (int j = 0; j < m; j++) {
                if (Ab[i][j] != 0) {
                    allZeroes = false;
                    break;
                }
            }
            if (!allZeroes) {
                rank++;
            }
        }
        if (rank < m) {
            System.out.println("Нет решений");
        } else if (rank > m) {
            System.out.println("Решений бесконечно много");
        } else {
            // Вывод решения СЛАУ
            for (int i = 0; i < m; i++) {
                System.out.printf("x%d = %.6f\n", i + 1, x[i]);
            }
        }
        return x;
    }
}

