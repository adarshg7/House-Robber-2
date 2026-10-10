import java.util.*;

public class Solution {

    public static int ninjaTraining(int n, int points[][]) {

        int dp[][] = new int[n][4];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(3, 0, points, n, dp);
    }

    public static int f(int prev, int idx, int points[][],
                        int n, int dp[][]) {

        if (idx >= n) return 0;

        if (dp[idx][prev] != -1) {
            return dp[idx][prev];
        }

        int ans = 0;

        for (int i = 0; i < 3; i++) {

            if (prev != i) {

                int pick = points[idx][i]
                         + f(i, idx + 1, points, n, dp);

                ans = Math.max(ans, pick);
            }
        }

        dp[idx][prev] = ans;

        return dp[idx][prev];
    }
}
