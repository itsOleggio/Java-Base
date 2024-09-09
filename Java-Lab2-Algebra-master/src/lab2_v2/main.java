package lab2_v2;
import lab2_v2.monoid.*;
import lab2_v2.group.*;
import lab2_v2.ring.*;
import lab2_v2.matrix.*;
public class main {
    public static void main(String[] args)
    {
        // Группа с умножением
        MultiplicativeIntegerGroup multiplicativeGroup = new MultiplicativeIntegerGroup(5);
        System.out.println("Группа с умножением:");
        System.out.println("Бинарная операция 5 * 3 = " + multiplicativeGroup.binaryOperation(new IntegerMonoid(3)).getValue());
        System.out.println("Нейтральный элемент: " + multiplicativeGroup.neutralElement().getValue());
        System.out.println("Обратный элемент: " + multiplicativeGroup.inverseElement().getValue());

        System.out.println();

        // Группа со сложением
        AdditiveIntegerGroup additiveGroup = new AdditiveIntegerGroup(5);
        System.out.println("Группа со сложением:");
        System.out.println("Бинарная операция 5 + 3 = " + additiveGroup.binaryOperation(new IntegerMonoid(3)).getValue());
        System.out.println("Нейтральный элемент: " + additiveGroup.neutralElement().getValue());
        System.out.println("Обратный элемент: " + additiveGroup.inverseElement().getValue());

        Ring<Integer> ring = new Ring<>(0, 1);
        Matrix<Integer> matrix1 = new Matrix<>(ring, 2, 2);
        matrix1.set(0, 0, 1);
        matrix1.set(0, 1, 2);
        matrix1.set(1, 0, 3);
        matrix1.set(1, 1, 4);

        Matrix<Integer> matrix2 = new Matrix<>(ring, 2, 2);
        matrix2.set(0, 0, 5);
        matrix2.set(0, 1, 6);
        matrix2.set(1, 0, 7);
        matrix2.set(1, 1, 8);

        Matrix<Integer> resultAddition = matrix1.add(matrix2);
        System.out.println("Сложение матриц:");
        resultAddition.printMatrix();

        Matrix<Integer> resultMultiplication = matrix1.multiply(matrix2);
        System.out.println("\nУмножение матриц:");
        resultMultiplication.printMatrix();

        Ring<Integer> ring1 = new Ring<>(0, 1);
        Matrix<Integer> matrix1_new = new Matrix<>(ring1, 4, 4);
        Matrix<Integer> matrix2_new = new Matrix<>(ring1, 4, 4);


        int value = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix1_new.set(i, j, value++);
            }
        }

        value = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix2_new.set(i, j, value += value);
            }
        }

        System.out.println("матрица 1:");
        matrix1_new.printMatrix();
        System.out.println("матрица 2:");
        matrix2_new.printMatrix();

        // Перемножение матриц
        Matrix<Integer> resultMatrixMultiplication = matrix1_new.multiply(matrix2_new);
        System.out.println("Умножение матриц :");
        resultMatrixMultiplication.printMatrix();

        Ring<Integer> ring3 = new Ring<>(0, 1);

        // Создание матриц 2x2
        Matrix<Integer> matrix3 = new Matrix<>(ring3, 2, 2);
        matrix3.set(0, 0, 1);
        matrix3.set(0, 1, 2);
        matrix3.set(1, 0, 5);
        matrix3.set(1, 1, 6);

        Matrix<Integer> matrix4 = new Matrix<>(ring3, 2, 2);
        matrix4.set(0, 0, 3);
        matrix4.set(0, 1, 4);
        matrix4.set(1, 0, 7);
        matrix4.set(1, 1, 8);

        Matrix<Integer> matrix5 = new Matrix<>(ring3, 2, 2);
        matrix5.set(0, 0, 9);
        matrix5.set(0, 1, 10);
        matrix5.set(1, 0, 13);
        matrix5.set(1, 1, 14);

        Matrix<Integer> matrix6 = new Matrix<>(ring3, 2, 2);
        matrix6.set(0, 0, 11);
        matrix6.set(0, 1, 12);
        matrix6.set(1, 0, 15);
        matrix6.set(1, 1, 16);


        Matrix<Integer> matrix4x4 = new Matrix<>(ring3, 4, 4);
        // Вставка матриц 2x2 в матрицу 4x4
        matrix4x4.setSubmatrix(0, 0, matrix3);
        matrix4x4.setSubmatrix(0, 2, matrix4);
        matrix4x4.setSubmatrix(2, 0, matrix5);
        matrix4x4.setSubmatrix(2, 2, matrix6);

        Matrix<Integer> matrix7 = new Matrix<>(ring3, 2, 2);
        matrix7.set(0, 0, 2);
        matrix7.set(0, 1, 4);
        matrix7.set(1, 0, 32);
        matrix7.set(1, 1, 64);

        Matrix<Integer> matrix8 = new Matrix<>(ring3, 2, 2);
        matrix8.set(0, 0, 8);
        matrix8.set(0, 1, 16);
        matrix8.set(1, 0, 128);
        matrix8.set(1, 1, 256);

        Matrix<Integer> matrix9 = new Matrix<>(ring3, 2, 2);
        matrix9.set(0, 0, 512);
        matrix9.set(0, 1, 1024);
        matrix9.set(1, 0, 8192);
        matrix9.set(1, 1, 16384);

        Matrix<Integer> matrix10 = new Matrix<>(ring3, 2, 2);
        matrix10.set(0, 0, 2048);
        matrix10.set(0, 1, 4096);
        matrix10.set(1, 0, 32768);
        matrix10.set(1, 1, 65536);

        Matrix<Integer> matrix4x4_2 = new Matrix<>(ring3, 4, 4);
        // Вставка матриц 2x2 в матрицу 4x4
        matrix4x4_2.setSubmatrix(0, 0, matrix7);
        matrix4x4_2.setSubmatrix(0, 2, matrix8);
        matrix4x4_2.setSubmatrix(2, 0, matrix9);
        matrix4x4_2.setSubmatrix(2, 2, matrix10);

        System.out.println("Матрица 1 4x4:");
        matrix4x4.printMatrix();
        System.out.println();
        System.out.println("Матрица 2 4x4:");
        matrix4x4_2.printMatrix();
        System.out.println();
        Matrix<Integer> resultMatrixMultiplication_2 = matrix4x4.multiply(matrix4x4_2);
        System.out.println("Умножение матрица 4 по 2x2 :");
        resultMatrixMultiplication_2.printMatrix();
    }
}
