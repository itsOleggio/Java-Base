package lab2_v1;

import java.math.BigInteger;

public class FastPowerBigInteger {
    private MultiplyBigIntegerMonoid multiplyMonoid;

    public FastPowerBigInteger() {
        this.multiplyMonoid = new MultiplyBigIntegerMonoid();
    }

    public BigInteger fastPower(BigInteger base, BigInteger exponent) {
        if (exponent.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        BigInteger result = BigInteger.ONE;
        BigInteger currentBase = base;
        while (!exponent.equals(BigInteger.ZERO)) {
            if (exponent.mod(BigInteger.TWO).equals(BigInteger.ONE)) {
                result = multiplyMonoid.operate(result, currentBase);
            }
            currentBase = multiplyMonoid.operate(currentBase, currentBase);
            exponent = exponent.divide(BigInteger.TWO);
        }
        return result;
    }
}
