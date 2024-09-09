package lab2_v1;

class FastOperation<T extends Number> {
    private Monoid<T> monoid;

    public FastOperation(Monoid<T> monoid) {
        this.monoid = monoid;
    }

    public T fastPower(T base, int exponent) {
        if (exponent == 0) {
            return monoid.identity();
        }
        T result = monoid.identity();
        T multiplier = base;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = monoid.operate(result, multiplier);
            }
            exponent >>= 1;
            multiplier = monoid.operate(multiplier, multiplier);
        }
        return result;
    }
}
