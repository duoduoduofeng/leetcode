package leetcodeproblems.LC_001_100;

// 72. [Edit Distance](https://leetcode.com/problems/edit-distance)

public class S_072_EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0 || n == 0) {
            return m+n;
        }

        int[] d = new int[n + 1];
        for(int j = 0; j <= n; j++) {
            d[j] = j;
        }

        for(int i = 1; i <= m; i++) {
            int old1 = d[0];
            d[0] = i;

            for(int j = 1; j <= n; j++) {
                int old2 = d[j];
                int cost = 1;
                if(word2.charAt(j-1) == word1.charAt(i-1)) {
                    cost = 0;
                }

                d[j] = Math.min(Math.min(d[j-1]+1, d[j]+1), old1 + cost);

                old1 = old2;
            }
        }

        return d[n];
    }
}

