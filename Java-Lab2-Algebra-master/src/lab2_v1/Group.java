package lab2_v1;

public interface Group<T> extends Monoid<T> {
    T inverse(T a);
    T add(T a, T b); // добавляем метод сложения
}