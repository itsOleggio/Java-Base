package lab2_v1;

public class MultiplicationGroup implements Group<Double> {
    @Override
    public Double identity() {
        return 1.0; // Нейтральный элемент для умножения
    }

    @Override
    public Double operate(Double a, Double b) {
        return a * b; // Операция умножения
    }

    @Override
    public Double inverse(Double a) {
        if (a == 0) {
            throw new ArithmeticException("Невозможно найти обратное значение нуля");
        }
        return 1.0 / a; // Обратный элемент для умножения
    }

    @Override
    public Double add(Double a, Double b) {
        throw new UnsupportedOperationException("Операция сложения не поддерживается в группе умножения");
    }
}

