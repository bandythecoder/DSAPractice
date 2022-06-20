package Algoritham;

public class DynamicProgramming_Knapsack01 {
    static int[][] t = new int[100][100];
    static boolean[][] t1 = new boolean[100][100];

    public DynamicProgramming_Knapsack01() {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }
    }

    // Memozization
    public int knapSackO1(int[] wt, int[] value, int m, int bagSize) {
        if (m == 0 || bagSize == 0) {
            return 0;
        }

        if (t[m - 1][bagSize] != -1) {
            return t[m - 1][bagSize];
        }
        //Code Choice Diagram
        if (wt[m - 1] > bagSize) {
            t[m - 1][bagSize] = knapSackO1(wt, value, m - 1, bagSize);
            return t[m - 1][bagSize];
        } else {
            return t[m - 1][bagSize] = t[m - 1][bagSize] = Math.max(value[m - 1] + knapSackO1(wt, value, m - 1, bagSize - wt[m - 1]), knapSackO1(wt, value, m - 1, bagSize));
        }

    }


    // TopDown
    public int knapSackO1TopDown(int[] wt, int[] value, int m, int bagSize) {
        if (m == 0 || bagSize == 0) {
            return 0;
        }

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < bagSize + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                    continue;
                }
                if (wt[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.max(value[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                }
            }

        }
        return t[m][bagSize];
    }


    public boolean subsetProblem(int[] arr, int length, int sum) {
        if (sum == 0) return true;
        if (length == 0 && sum > 0) return false;
        if (arr[length - 1] > sum) {
            return subsetProblem(arr, length - 1, sum);
        } else {
            return subsetProblem(arr, length - 1, sum) || subsetProblem(arr, length - 1, sum - arr[length - 1]);
        }
    }


    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    boolean canJump(int[] nums, int start) {
        if (start == nums.length - 1) return true;

        boolean jump = false;
        boolean Prevjump = false;
        for (int i = start + 1; i < nums.length && i <= start + nums[start]; i++) {
            Prevjump = canJump(nums, i);
            jump = jump || Prevjump;

        }
        return jump;
    }

    public int subSetcount(int[] arr, int length, int sum) {

        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {

                if (i == 0 && j != 0) {
                    t[i][j] = 0;
                    continue;
                }
                if (j == 0) {
                    t[i][j] = 1;
                    continue;
                }

                if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                }
            }


        }
        return t[length][sum];
    }

    public int minDifferenceInSubset(int arr[], int length) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        boolean[] arr1 = subsetSum(arr, length, sum);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length / 2; i++) {
            if (arr1[i]) {
                min = Math.min(Math.abs(sum - (2 * i)), min);
            }
        }
        return min;
    }

    public boolean[] subsetSum(int arr[], int length, int sum) {
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j != 0) {
                    t1[i][j] = false;
                    continue;
                }
                if (j == 0) {
                    t1[i][j] = true;
                    continue;
                }
                if (arr[i - 1] > j) {
                    t1[i][j] = t1[i - 1][j];
                } else {
                    t1[i][j] = t1[i - 1][j] || t1[i - 1][j - arr[i - 1]];
                }
            }

        }
        return t1[length];
    }

    public int subsetCountwithDifference(int[] arr, int diff) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        sum = (sum + diff) / 2;
        int count = subsetCount(arr, arr.length, sum);
        return count;

    }

    private int subsetCount(int[] arr, int length, int sum) {

        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j != 0) {
                    t[i][j] = 0;
                    continue;
                }
                if (j == 0) {
                    t[i][j] = 1;
                    continue;
                }

                if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                }

            }
        }
        return t[length][sum];
    }

    public int maxProfitRodCutting(int[] length, int[] price, int m, int n) {
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                    continue;
                }
                if (length[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - length[i - 1]] + price[i - 1]);
                }

            }

        }
        return t[m][n];
    }

    public int coinChangeProblem(int[] coin, int length, int sum) {
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j != 0) {
                    t[i][j] = 0;
                    continue;
                }
                if (j == 0) {
                    t[i][j] = 1;
                    continue;
                }

                if (coin[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j] + t[i][j - coin[i - 1]];
                }

            }
        }
        return t[length][sum];
    }

    public int maxProduct(int[] nums) {
        int t[] = new int[nums.length];
        t[0] = nums[0];
        int max  = nums[0];
        for(int i = 1; i < nums.length-1; i++)
        {
            if((t[i-1] * nums[i]) > nums[i])
            {
                t[i] = t[i-1] * nums[i];
            }
            else
            {
                t[i] = nums[i];
            }
            max = Math.max(t[i], max);
        }


        return max;
    }
    public int minCoin(int[] coin, int length, int sum) {

        for (int i = 0; i < sum + 1; i++) {
            t[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i < coin.length + 1; i++) {
            t[i][0] = 0;
        }

        for (int i = 1; i < sum + 1; i++) {
            if (i % coin[0] == 0) {
                t[1][i] = i / coin[0];
            } else {
                t[1][i] = Integer.MAX_VALUE - 1;
            }
        }
        //Fill matrix

        for (int i = 2; i < length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (coin[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = Math.min(t[i - 1][j], 1 + t[i - 1][j - coin[i - 1]]);
                }
            }
        }


        return t[length][sum];
    }
}
