import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GFG {

    // Function to count numbers having
// exactly 9 divisors
    static long countNumbers(long n) {
        int c = 0;

        int limit = (int) Math.sqrt(n);

        // Sieve array
        int prime[] = new int[limit + 1];

        // initially prime[i] = i
        for (int i = 1; i <= limit; i++) {
            prime[i] = i;
        }

        // use sieve concept to store the
        // first prime factor of every number
        for (int i = 2; i * i <= limit; i++) {
            if (prime[i] == i) {
                // mark all factors of i
                for (int j = i * i; j <= limit; j += i) {
                    if (prime[j] == j) {
                        prime[j] = i;
                    }
                }
            }
        }



        // check for all numbers if they can be
        // expressed in form p*q
        for (int i = 2; i <= limit; i++) {
            // p prime factor
            int p = prime[i];

            // q prime factor
            int q = prime[i / prime[i]];

            // if both prime factors are different
            // if p*q<=n and q!=
            if (p * q == i && q != 1 && p != q) {
                c += 1;
            } else if (prime[i] == i) {

                // Check if it can be expressed as p^8
                if (Math.pow(i, 8) <= n) {

                    c += 1;
                }
            }
        }

        return c;
    }

    static void towerOfHanoi(int n, char from_rod,
                             char to_rod, char aux_rod)
    {
        if (n == 0)
        {
            return;
        }
        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk "+ n + " from rod " +
                from_rod +" to rod " + to_rod );
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    public static int maxCoins(int arr[],int n)
    {
        int table[][] = new int[n][n];
        int gap, i, j, x, y, z;

        for (gap = 0; gap < n; ++gap) {
            for (i = 0, j = gap; j < n; ++i, ++j) {

                // Here x is value of F(i+2, j),
                // y is F(i+1, j-1) and z is
                // F(i, j-2) in above recursive formula
                x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                y = ((i + 1) <= (j - 1))
                        ? table[i + 1][j - 1]
                        : 0;
                z = (i <= (j - 2)) ? table[i][j - 2] : 0;

                table[i][j]
                        = Math.max(arr[i] + Math.min(x, y),
                        arr[j] + Math.min(y, z));
            }
        }

        return table[0][n - 1];
    }

    public static int lenOfLongSubarr (int arr[], int N, int k) {
        //Complete the function
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;

        // traverse the given array
        for (int i = 0; i < N; i++) {

            // accumulate sum
            sum += arr[i];

            // when subarray starts from index '0'
            if (sum == k)
                maxLen = i + 1;

            // make an entry for 'sum' if it is
            // not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            // check if 'sum-k' is present in 'map'
            // or not
            if (map.containsKey(sum - k)) {

                // update maxLength
                if (maxLen < (i - map.get(sum - k)))
                    maxLen = i - map.get(sum - k);
            }
        }

        return maxLen;
    }
    // Driver Code
    public static void main(String[] args) {
        long n = 100;

        System.out.println(countNumbers(n));
        int n1 = 4;
        towerOfHanoi(n1, 'A', 'C', 'B');

        int arr[]=new int[]{4,7,11,1,9,14};
        System.out.println(maxCoins(arr,arr.length));

        int A[] =new int[]{10, 5, 2, 7, 1, 9};
        int k = 15;
        int n2=A.length;
        lenOfLongSubarr(A,n2,k);


    }
}