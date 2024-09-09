package lab2_v2.monoid;

public abstract class AbstractMonoid<T> implements Monoid<T> {
    public abstract T binaryOperation(T other);

    public abstract T neutralElement();
}
