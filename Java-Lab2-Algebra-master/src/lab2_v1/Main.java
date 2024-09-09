package lab2_v1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // Пункт 1: Моноиды
        System.out.println("=== Моноиды ===");

        // Пример использования моноидов
        // 1.1 Реализация интерфейса lab2_v1.Monoid
        Monoid<Integer> maxMonoid = new MaxMonoid();
        Monoid<Double> minDoubleMonoid = new MinDoubleMonoid();

        // 1.2 Моноиды с операциями максимума и минимума
        System.out.println("Максимум из 5 и 7: " + maxMonoid.operate(5, 7));
        // System.out.println("Минимум из 5.5 и 7.7: " + minMonoid.operate(5, 7));
        System.out.println("Минимум из 5.5 и 7.7: " + minDoubleMonoid.operate(5.5, 7.7));

        // 1.3 Простое дерево отрезков
        Integer[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(array, maxMonoid);
        // Вывод заголовка
        System.out.print("Index | ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-3d| ", i);
        }
        System.out.println(); // Перейти на новую строку

        // Вывод значений
        System.out.print("Value | ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%-3d| ", array[i]);
        }

        System.out.println(); // Перейти на новую строку
        System.out.println("Максимум в диапазоне [1, 4]: " + segmentTree.query(1, 4));

        // 1.4 Быстрое возведение в степень
        // Создаем моноид для операции умножения
        Monoid<Integer> multiplyMonoid = new MultiplyMonoid();

        // Пример использования
        FastOperation<Integer> fastOperation = new FastOperation<>(multiplyMonoid);
        System.out.println("Быстрое возведение 2 в степень 5: " + fastOperation.fastPower(2, 5));

        // Определяем основание и показатель степени
        BigInteger bigBase = BigInteger.valueOf(2);
        long bigExponent = 64;

        // Выполняем операцию быстрого возведения в степень
        FastPowerBigInteger fastPowerBigInteger = new FastPowerBigInteger();
        BigInteger result = fastPowerBigInteger.fastPower(bigBase, BigInteger.valueOf(bigExponent));
        System.out.println("Быстрое возведение 2 в степень 64: " + result);

        // Пункт 2: Группы
        System.out.println("\n=== Группы ===");

        // 2.1 Реализация интерфейса lab2_v1.Group
        Group<Integer> additionGroup = new AdditionGroup();
        Group<Double> multiplicationGroup = new MultiplicationGroup();

        // 2.2 Группа со сложением
        System.out.println("Обратный элемент для числа 5 в группе по сложению: " + additionGroup.inverse(5));

        // 2.3 Группа с умножением
        //System.out.println("Обратный элемент для числа 5 в группе по умножению: " + multiplicationGroup.inverse(5));
        System.out.println("Обратный элемент для числа 5 в группе по умножению: " + (double) multiplicationGroup.inverse(5.0));

        // 2.4 Префиксная сумма
        int[] prefixArray = {3, 1, 4, 1, 5, 9, 2, 6};
        PrefixSum prefixSum = new PrefixSum(prefixArray);
        System.out.println("Префиксная сумма на интервале [2, 5]: " + prefixSum.query(2, 5));

        // Пункт 3: Кольца
        System.out.println("\n=== Кольца ===");

        // 3.1 Реализация кольца из моноида и группы

        Ring<Integer> integerRing = new Ring<>(new IntegerRing(), new IntegerRing());

        // 3.2 Реализация кольца над логическими значениями
        //Ring<Boolean> booleanRing = new Ring<>(new BooleanRing(), new BooleanRing());

        BooleanRing booleanRing = new BooleanRing();
        System.out.println("Логическое ИЛИ: " + booleanRing.operate(true, false));
        System.out.println("Логическое И: " + booleanRing.multiply(true, false));

        // 3.3 Реализация матрицы над кольцами
        Integer[][] matrix1 = {{1, 2}, {3, 4}};
        Integer[][] matrix2 = {{5, 6}, {7, 8}};
        Matrix<Integer> matrixA = new Matrix<>(matrix1, integerRing, Integer.class);
        Matrix<Integer> matrixB = new Matrix<>(matrix2, integerRing, Integer.class);


        // Выполняем умножение матриц
        Matrix<Integer> matrixProduct = matrixA.multiply(matrixB);

        // Вывод результатов
        System.out.println("Матрица А * Матрица Б:");
        for (Integer[] row : matrixProduct.getElements()) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Выполняем сложение матриц
        Matrix<Integer> matrixSum = matrixA.add(matrixB);

        System.out.println("Матрица А + Матрица Б:");
        for (Integer[] row : matrixSum.getElements()) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }


        // 3.4 Реализация полинома над кольцами
        List<Integer> poly1 = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> poly2 = new ArrayList<>(List.of(4, 5, 6));
        Polynomial<Integer> polynomialA = new Polynomial<>(poly1, integerRing);
        Polynomial<Integer> polynomialB = new Polynomial<>(poly2, integerRing);
        Polynomial<Integer> polynomialC = polynomialA.multiply(polynomialB);

        // Вывод результатов полиномов
        System.out.println("Полином А * Полином Б: " + polynomialC.getCoefficients());

        System.out.println("\n=== Преобразование ===");
        System.out.println("=== (Дополнительно) ===");

        // Преобразование полинома в матрицу
        Matrix<Integer> polynomialMatrix = polynomialA.toMatrix();

        // Вывод элементов матрицы
        System.out.println("Матрица, полученная из полинома A:");
        for (Integer[] row : polynomialMatrix.getElements()) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Преобразование матрицы обратно в полином
        Polynomial<Integer> convertedPolynomialA = polynomialMatrix.toPolynomial();

        // Вывод коэффициентов полинома
        System.out.println("Полином, полученный из матрицы A: " + convertedPolynomialA.getCoefficients());
        printPolynomial(convertedPolynomialA.getCoefficients());
    }

    // Вывод палинома
    private static void printPolynomial(List<Integer> coefficients) {
        int degree = coefficients.size() - 1;
        System.out.print("P(x) = ");
        for (int i = degree; i >= 0; i--) {
            if (coefficients.get(i) != 0) {
                if (i == 0) {
                    System.out.print(coefficients.get(i));
                } else {
                    System.out.print(coefficients.get(i) + " * x^" + i);
                }
                if (i != 0) {
                    System.out.print(" + ");
                }
            }
        }
        System.out.println();
    }
}
