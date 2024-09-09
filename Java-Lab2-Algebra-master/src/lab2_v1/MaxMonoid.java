package lab2_v1;

public class MaxMonoid implements Monoid<Integer> {
    @Override
    public Integer identity() {
        return Integer.MIN_VALUE; // Нейтральный элемент для максимума
    }

    @Override
    public Integer operate(Integer a, Integer b) {
        return Math.max(a, b); // Операция максимума
    }
}

