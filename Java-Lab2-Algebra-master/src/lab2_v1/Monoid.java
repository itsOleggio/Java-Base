package lab2_v1;

public interface Monoid<T> {
    T identity(); // Нейтральный элемент

    T operate(T a, T b); // Бинарная операция
}