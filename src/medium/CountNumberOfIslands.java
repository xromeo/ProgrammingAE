package medium;

/*
Given an m x n 2D binary which represents a map of 0s (water) and 1s (land), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all edges of the grid are all surrounded by water.

Example Input 1:
1 1 1 1 0
1 1 0 1 0
1 1 0 0 0
0 0 0 0 0
Output is 1 because all the 1s (Marked with blue) were part of a single connected component.

Example Input 2:
1  1  0  0  0
1  1  0  0  0
0  0  1  1  0
0  0  1  1  0
The output is 2 because there are two separate groups of 1s (red and blue).
 */

public class CountNumberOfIslands {
    public static int numIslands(int[][] grid) {       

        int count = 0;

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                    dfs(grid, i, j, visited);
                }   
            }            
        }

        return count;
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited){
        if( i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return;
        }

        visited[i][j] = true;

        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j - 1, visited);
    }

    public static void main(String[] args) {
        

        // Ejemplo 1
        int[][] grid1 = {
            {1, 1, 1, 1, 0},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
        System.out.println("Número de islas (Ejemplo 1): " + numIslands(grid1)); // Output: 1

        // Ejemplo 2
        int[][] grid2 = {
            {1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 0, 1, 1}
        };
        System.out.println("Número de islas (Ejemplo 2): " + numIslands(grid2)); // Output: 3

    }
}
