package lab2_v1;

public class MinDoubleMonoid implements Monoid<Double> {
    @Override
    public Double identity() {
        return Double.POSITIVE_INFINITY; // Нейтральный элемент для минимума
    }

    @Override
    public Double operate(Double a, Double b) {
        return Math.min(a, b); // Операция минимума
    }
}