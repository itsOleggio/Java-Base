package lab2_v1;

public class Ring<T> implements Group<T> {
    private final Group<T> additionGroup;
    private final Monoid<T> multiplicationMonoid;

    public Ring(Group<T> additionGroup, Monoid<T> multiplicationMonoid) {
        this.additionGroup = additionGroup;
        this.multiplicationMonoid = multiplicationMonoid;
    }

    @Override
    public T identity() {
        return additionGroup.identity();
    }

    @Override
    public T operate(T a, T b) {
        return additionGroup.operate(a, b);
    }

    @Override
    public T inverse(T a) {
        return additionGroup.inverse(a);
    }

    public T multiply(T a, T b) {
        return multiplicationMonoid.operate(a, b);
    }

    @Override
    public T add(T a, T b) {
        return additionGroup.add(a, b); // Реализация метода сложения
    }
}





/*
 * 1. Исправлено наследование Ringa. Теперь наследуется от lab2_v1.Group, которая наследуется от lab2_v1.Monoid 13.04.2024 - DONE
 * */