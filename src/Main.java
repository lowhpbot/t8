import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(JOptionPane.showInputDialog("Введите размерность матриц (n):"));
            double minRange = Double.parseDouble(JOptionPane.showInputDialog("Введите минимальное значение диапазона:"));
            double maxRange = Double.parseDouble(JOptionPane.showInputDialog("Введите максимальное значение диапазона:"));

            if (n <= 0 || minRange >= maxRange) {
                throw new IllegalArgumentException("Некорректные данные.");
            }

            double[][] matrixA = generateMatrix(n, minRange, maxRange);
            double[][] matrixB = generateMatrix(n, minRange, maxRange);
            double[][] resultMatrix = multiplyMatrices(matrixA, matrixB, n);

            StringBuilder result = new StringBuilder();
            result.append("Матрица A:\n").append(matrixToString(matrixA, n))
                    .append("\nМатрица B:\n").append(matrixToString(matrixB, n))
                    .append("\nРезультат произведения:\n").append(matrixToString(resultMatrix, n));

            JOptionPane.showMessageDialog(null, result.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Некорректный ввод. Пожалуйста, введите числовые значения.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private static double[][] generateMatrix(int size, double min, double max) {
        double[][] matrix = new double[size][size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = min + (max - min) * random.nextDouble();
            }
        }
        return matrix;
    }

    private static double[][] multiplyMatrices(double[][] a, double[][] b, int size) {
        double[][] result = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    private static String matrixToString(double[][] matrix, int size) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(String.format("%10.4f", matrix[i][j])).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}