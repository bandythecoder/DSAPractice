package RangeQueries.SengmentTree;

public class MinMaxValue {


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 2, 6, 4};
        SegmentTree s = new SegmentTree(arr);
        var value = s.query(1, 6);
        System.out.println(value);
    }


    public static class SegmentTree {
        int tree[];
        int arr[];
        int MAX;

        SegmentTree(int arr[]) {
            int n = arr.length;
            tree = new int[4 * n];
            this.arr = arr;
            MAX = n;
            build(0, n - 1, 0);
        }

        void build(int start, int end, int node) {
            if (start == end) {
                tree[node] = arr[start];
            } else {
                int mid = start + (end - start) / 2;

                build(start, mid, 2 * node + 1);
                build(mid + 1, end, 2 * node + 2);
                tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
            }
        }

        int findAns(int l, int r, int start, int end, int node) {
            if (l > end || r < start) {
                return Integer.MIN_VALUE;
            }
            if (l <= start && r >= end) {
                return tree[node];
            } else {
                int mid = start + (end - start) / 2;
                int left = findAns(l, r, start, mid, 2 * node + 1);
                int right = findAns(l, r, mid + 1, end, 2 * node + 1);
                return Math.max(left, right);

            }
        }

        int query(int l, int r) {
            int start = 0;
            int end = MAX - 1;
            return findAns(l, r, start, end, 0);
        }
    }
}
