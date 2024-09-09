package lab2_v1;

public class BooleanRing implements Monoid<Boolean>, Group<Boolean> {
    @Override
    public Boolean identity() {
        return true; // Логическая истина как нейтральный элемент
    }

    @Override
    public Boolean operate(Boolean a, Boolean b) {
        return a || b; // Логическое И как операция сложения
    }

    @Override
    public Boolean inverse(Boolean a) {
        return !a; // Отрицание как операция взятия обратного элемента
    }

    @Override
    public Boolean add(Boolean a, Boolean b) {
        return a || b; // Операция сложения
    }

    public Boolean multiply(Boolean a, Boolean b) {
        return a && b; // Операция умножения
    }
}


