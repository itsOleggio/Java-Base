package lab2_v2.group;

import lab2_v2.monoid.AbstractMonoid;

public abstract class AbstractGroup<T> extends AbstractMonoid<T> implements Group<T> {
    public abstract T inverseElement();

    // Метод identity возвращает нейтральный элемент по умолчанию
    public T identity() {
        return neutralElement();
    }
}
