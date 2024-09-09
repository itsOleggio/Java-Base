package lab2_v2.monoid;


public class IntegerMonoid extends AbstractMonoid<IntegerMonoid> {
    private int value;

    public IntegerMonoid(int value) {
        this.value = value;
    }

    public IntegerMonoid binaryOperation(IntegerMonoid other) {
        return new IntegerMonoid(this.value * other.getValue());
    }

    @Override
    public IntegerMonoid neutralElement() {
        return new IntegerMonoid(1);
    }


    public int getValue() {
        return value;
    }
}


