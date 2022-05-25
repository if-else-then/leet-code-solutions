class Solution {
    private int[][]grid;
    private boolean[][] visited;
    private int rows=0;
    private int cols=0;
    private int max = 0;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new boolean[rows][cols];
        for (int i =0; i< rows; ++i) {
            for (int j =0; j< cols; ++j) {
                    max = Math.max(max, mapIt(i,j));
            }
        }
        return max;
    }
        
    private int mapIt(int i, int j) {
            if(visited[i][j] == true) return 0;
            visited[i][j] = true;
            if (grid[i][j] == 0) return 0;
            int len = 1;
            
            
            if(i >= 1) len += mapIt(i-1, j);
            if(j >= 1) len += mapIt(i, j-1);
            if(i+1 < rows) len += mapIt(i+1, j);
            if(j+1< cols) len += mapIt(i, j+1);
            return len;
        }
    
}
