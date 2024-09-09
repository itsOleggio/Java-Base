package lab2_v2.ring;

import lab2_v2.group.AdditiveIntegerGroup;
import lab2_v2.group.Group;
import lab2_v2.monoid.IntegerMonoid;

public class Ring<T> implements Group<T> {
    private T zero;
    private T one;
    private AdditiveIntegerGroup additiveGroup;

    public Ring(T zero, T one) {
        this.zero = zero;
        this.one = one;
        this.additiveGroup = new AdditiveIntegerGroup(0);
    }

    @Override
    public T inverseElement() {
        return null;
    }

    @Override
    public T identity() {
        return zero;
    }

    public T multiply(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            IntegerMonoid aValue = new IntegerMonoid((Integer) a);
            IntegerMonoid bValue = new IntegerMonoid((Integer) b);
            IntegerMonoid result = aValue.binaryOperation(bValue);
            return (T) (Integer) result.getValue();
        }
        return null;
    }

    public T add(T a, T b) {
        if (a instanceof Integer && b instanceof Integer) {
            IntegerMonoid aValue = new IntegerMonoid((Integer) a);
            IntegerMonoid bValue = new IntegerMonoid((Integer) b);
            IntegerMonoid result = additiveGroup.binaryOperation(aValue, bValue);
            return (T) (Integer) result.getValue();
        }
        return null;
    }

    public T inverseElement(T a) {
        if (a instanceof Integer) {
            return (T) (Integer) (-(Integer) a);
        }
        return null;
    }

    public T getZero() {
        return zero;
    }

    public T binaryOperation(T other) {
        return null;
    }

    public T neutralElement() {
        return null;
    }
}
