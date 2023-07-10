package DSAMath;

import java.util.*;

public class Sieve {
    int n = (int) (10e5 + 7);
    boolean[] isPrime = new boolean[(int) (10e5 + 7)];
    int[] HP = new int[(int) (10e5 + 7)];
    int[] LP = new int[(int) (10e5 + 7)];

    Map<Integer, List<Integer>> map = new TreeMap<>();

    public Sieve() {
        computeHighestPrime();
    }

    public List<Integer> primeNumbers(int n) {
      List<Integer> res = new ArrayList<>();
        boolean[] arr = new boolean[n + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!arr[i]) {
                for (int j = 2 * i; j <= n; j = j + i) {
                    arr[j] = true;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (!arr[i]) {
                res.add(i);
            }
        }

        return res;
    }

    public void computeHighestPrime() {
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2 * i; j < n; j = j + i) {
                    isPrime[j] = false;
                    HP[j] = i;
                    map.putIfAbsent(j, new ArrayList<>());
                    map.get(j).add(i);
                    if (LP[j] == 0) {
                        LP[j] = i;
                    }
                }
            }
        }
    }

    public int getHP(int n) {
        return HP[n];
    }

    public int getLP(int n) {
        return LP[n];
    }

    public List<Integer> getPrimeFactor(int n)
    {
        return map.get(n);
    }
}
