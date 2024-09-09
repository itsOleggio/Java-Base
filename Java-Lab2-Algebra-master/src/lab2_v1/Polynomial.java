package lab2_v1;

import java.util.ArrayList;
import java.util.List;

public class Polynomial<T> {
    private List<T> coefficients;
    private Ring<T> ring;

    // Конструктор класса
    public Polynomial(List<T> coefficients, Ring<T> ring) {
        this.coefficients = coefficients;
        this.ring = ring;
    }

    // Геттер для получения коэффициентов полинома
    public List<T> getCoefficients() {
        return coefficients;
    }

    // Метод для умножения полиномов
    public Polynomial<T> multiply(Polynomial<T> other) {
        int m = this.coefficients.size();
        int n = other.coefficients.size();

        // Вычисление степени результирующего полинома
        List<T> resultCoefficients = new ArrayList<>(m + n - 1);

        // Инициализация списка коэффициентов результата нулями
        for (int i = 0; i < m + n - 1; i++) {
            resultCoefficients.add(ring.identity());
        }

        // Умножение полиномов
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                T product = ring.multiply(this.coefficients.get(i), other.coefficients.get(j));
                T current = resultCoefficients.get(i + j);
                resultCoefficients.set(i + j, ring.operate(current, product));
            }
        }

        return new Polynomial<>(resultCoefficients, ring);
    }

    // Метод для преобразования полинома в матрицу
    public Matrix<T> toMatrix() {
        // 1. Определение размерности матрицы
        int size = coefficients.size();

        // 2. Создание списка списков для данных матрицы
        List<List<T>> matrixData = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<T> row = new ArrayList<>(size);
            for (int j = 0; j < size; j++) {
                if (j == i) {
                    row.add(coefficients.get(j)); // Коэффициент полинома на главной диагонали
                } else {
                    row.add(ring.identity()); // Элемент идентичности кольца для недиагональных элементов
                }
            }
            matrixData.add(row);
        }

        // 3. Создание двумерного массива элементов матрицы
        T[][] elements = createArray(size, size, (Class<T>) coefficients.get(0).getClass());
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                elements[i][j] = matrixData.get(i).get(j);
            }
        }

        // 4. Возвращение новой матрицы
        return new Matrix<>(elements, ring, (Class<T>) coefficients.get(0).getClass());
    }



    /* toMatrix
     * 1. Определяется размерность матрицы, которая будет равна размерности полинома. Это количество коэффициентов в полиноме.
     * 2. Создается список списков matrixData, который представляет собой данные матрицы. Каждый внутренний список представляет одну строку матрицы. В этом списке каждый элемент на главной диагонали (где i == j) содержит коэффициент полинома, а все остальные элементы заполняются нулями или идентичными элементами кольца.
     * 3. Создается двумерный массив elements, который будет содержать элементы матрицы. Элементы берутся из списка matrixData.
     * 4. Созданная матрица возвращается как результат.
     * */

    // Приватный вспомогательный метод для создания массива
    private T[][] createArray(int rows, int cols, Class<T> clazz) {
        return (T[][]) java.lang.reflect.Array.newInstance(clazz, rows, cols);
    }
}
