public class Main {
    public static void main(String[] args) {
        int[][] grid1 = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };
        System.out.println(shortestWay(grid1)); // Вывод: 7

        int[][] grid2 = {
            {2, 7, 3},
            {1, 4, 8},
            {4, 5, 9}
        };
        System.out.println(shortestWay(grid2)); // Вывод: 21
    }

    public static int shortestWay(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        // Заполняем начальное значение в первой ячейке
        dp[0][0] = grid[0][0];

        // Заполняем первую строку и первый столбец
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Заполняем остальные ячейки
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // Возвращаем минимальную сумму пути до правого нижнего угла
        return dp[n - 1][n - 1];
    }
}
