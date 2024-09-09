package lab2_v1;

public class PrefixSum {
    private int[] prefixSum;

    public PrefixSum(int[] array) {
        int n = array.length;
        prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1];
        }
    }

    public int query(int l, int r) {
        return prefixSum[r + 1] - prefixSum[l];
    }
}
