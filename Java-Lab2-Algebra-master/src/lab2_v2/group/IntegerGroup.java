package lab2_v2.group;


public class IntegerGroup extends AbstractGroup<Integer> {
    private int value;

    public IntegerGroup(int value) {
        this.value = value;
    }

    public Integer binaryOperation(Integer other) {
        return this.value + other;
    }

    public Integer neutralElement() {
        return 0;
    }

    public Integer inverseElement() {
        return -this.value;
    }
}
