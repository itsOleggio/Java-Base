package lab2_v2.group;

import lab2_v2.monoid.*;

public class MultiplicativeIntegerGroup extends AbstractGroup<IntegerMonoid> {
    private IntegerMonoid value;

    public MultiplicativeIntegerGroup(int value) {
        this.value = new IntegerMonoid(value);
    }

    @Override
    public IntegerMonoid binaryOperation(IntegerMonoid other) {
        return new IntegerMonoid(this.value.getValue() * other.getValue());
    }

    @Override
    public IntegerMonoid neutralElement() {
        return new IntegerMonoid(1);
    }

    @Override
    public IntegerMonoid inverseElement() {
        return new IntegerMonoid(1 / this.value.getValue());
    }
}
