package lab2_v1;

public class SegmentTree<T> {
    private T[] tree;
    private Monoid<T> monoid;

    public SegmentTree(T[] array, Monoid<T> monoid) {
        int n = array.length;
        this.monoid = monoid;
        tree = (T[]) new Object[4 * n];
        build(array, 1, 0, n - 1);
    }

    private void build(T[] array, int v, int tl, int tr) {
        if (tl == tr) {
            tree[v] = array[tl];
        } else {
            int tm = (tl + tr) / 2;
            build(array, v * 2, tl, tm);
            build(array, v * 2 + 1, tm + 1, tr);
            tree[v] = monoid.operate(tree[v * 2], tree[v * 2 + 1]);
        }
    }

    public T query(int v, int tl, int tr, int l, int r) {
        if (l > r) {
            return monoid.identity();
        }
        if (l == tl && r == tr) {
            return tree[v];
        }
        int tm = (tl + tr) / 2;
        return monoid.operate(query(v * 2, tl, tm, l, Math.min(r, tm)),
                query(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
    }

    public T query(int l, int r) {
        return query(1, 0, tree.length / 4 - 1, l, r);
    }
}
