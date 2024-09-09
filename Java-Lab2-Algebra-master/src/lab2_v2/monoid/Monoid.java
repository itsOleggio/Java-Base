package lab2_v2.monoid;

public interface Monoid<T> {
    T binaryOperation(T other);
    T neutralElement();
}
