package lab2_v2.group;

import lab2_v2.monoid.Monoid;

public interface Group<T> extends Monoid<T>
{
    T inverseElement();

    T identity();
}
