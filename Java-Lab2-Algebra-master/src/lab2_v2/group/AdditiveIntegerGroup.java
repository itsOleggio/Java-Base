package lab2_v2.group;

import lab2_v2.monoid.*;
public class AdditiveIntegerGroup extends AbstractGroup<IntegerMonoid> {
    private IntegerMonoid value;

    public AdditiveIntegerGroup(int value) {
        this.value = new IntegerMonoid(value);
    }

    public IntegerMonoid binaryOperation(IntegerMonoid other) {
        return new IntegerMonoid(this.value.getValue() + other.getValue());
    }
    public IntegerMonoid binaryOperation(IntegerMonoid other, IntegerMonoid other2) {
        return new IntegerMonoid(other2.getValue() + other.getValue());
    }

    public IntegerMonoid neutralElement() {
        return new IntegerMonoid(0);
    }

    public IntegerMonoid inverseElement() {
        return new IntegerMonoid(-this.value.getValue());
    }
}
