public class StringSimilairtyUsingZIndex {
    public static long stringSimilarity(String str) {
        // Write your code here
        //ababaa window=aba#ababaa
        long c=str.length();
        int L = 0, R = 0,n=str.length();
        char[] s = str.toCharArray();
        int []z=new int[n];
        for (int i = 1; i < n; i++) {
            if (i > R) {//window means pattern
                L = R = i;
                while (R < n && s[R-L] == s[R]) R++;
                z[i] = R-L; R--;
                c+=z[i];
            } else {
                int k = i-L;//specifies our current index's position inside the window
                int val=R-i+1;// number of elements inside the window after k
                    if (z[k] < R-i+1) {
                    z[i] = z[k];
                    c+=z[i];
                }
                else {
                    L = i;
                    while (R < n && s[R-L] == s[R]) R++;
                    z[i] = R-L;
                    c+=z[i];
                    R--;
                }
            }
        }
        return c;

    }
    public static void main(String[] args) {
        System.out.println(stringSimilarity("ababaa"));
    }
}
