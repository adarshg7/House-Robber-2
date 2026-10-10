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

//or

public class Solution {

    public static int ninjaTraining(int n, int points[][]) {

        int dp[][] = new int[n][4];

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);

        dp[0][3] = Math.max(
            points[0][0],
            Math.max(points[0][1], points[0][2])
        );

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < 4; j++) {

                dp[i][j] = 0;

                for (int k = 0; k < 3; k++) {

                    if (j != k) {

                        int pick = points[i][k] + dp[i - 1][k];

                        dp[i][j] = Math.max(dp[i][j], pick);
                    }
                }
            }
        }

        return dp[n - 1][3];
    }
}
