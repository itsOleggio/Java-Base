package lab2_v1;

public class IntegerRing implements Monoid<Integer>, Group<Integer> {
    @Override
    public Integer identity() {
        return 0;
    }

    @Override
    public Integer operate(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer inverse(Integer a) {
        return -a;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b; // Операция сложения
    }
}

