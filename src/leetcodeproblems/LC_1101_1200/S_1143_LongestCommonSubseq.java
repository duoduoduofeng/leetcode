package leetcodeproblems.LC_1101_1200;

//1143. [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence)
public class S_1143_LongestCommonSubseq {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int m = text1.length();
        int n = text2.length();
        int[] lcs = new int[n+1];

        for(int i = 1; i <= m; i++) {
            int old1 = lcs[0];
            lcs[0] = 0;
            for(int j = 1; j <= n; j++) {
                int tmp = lcs[j];

                int common = 0;
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    common = 1;
                }

                lcs[j] = Math.max(old1 + common, Math.max(lcs[j-1], lcs[j]));

                old1 = tmp;
            }
        }

        return lcs[n];
    }
}
