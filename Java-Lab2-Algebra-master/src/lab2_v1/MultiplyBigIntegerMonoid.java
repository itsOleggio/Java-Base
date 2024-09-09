package lab2_v1;

import java.math.BigInteger;

public class MultiplyBigIntegerMonoid implements Monoid<BigInteger> {
    @Override
    public BigInteger identity() {
        return BigInteger.ONE; // Нейтральный элемент для умножения
    }

    @Override
    public BigInteger operate(BigInteger a, BigInteger b) {
        return a.multiply(b); // Операция умножения
    }
}
