class Solution {

    public int orangesRotting(int[][] grid) {
        int maxOranges = grid.length * grid[0].length;
        for (int i =0; i< grid.length; ++i) {
            for (int j =0; j< grid[0].length; ++j){
                if (grid[i][j] == 0) {
                    --maxOranges;
                }
            }
        }
        // no oranges to rot
        if(maxOranges == 0) {
            return 0;
        }
        
        // if no orange to start spread of rot
        int numRotten = rot(grid);
        if (numRotten == 0) {
            return -1;
        }
        
        // if all are rotten
        if (numRotten == maxOranges) {
            return 0;
        }
        
        printGrid(grid);
        return sol(grid, maxOranges);
    }
    
    private int sol(int[][] grid, int maxOranges) {
        int[][] visited = new int[grid.length][grid[0].length];
        int visitedOranges = 0; // temp variable
        int seconds = 0;
        
        int rotted = rot(grid);
        
        while (visitedOranges != maxOranges){
            ++seconds;
            // below, consider every increment of i is one second passed
            // visit every orange and if neighbour need to be rotten mark it
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j<grid[0].length; ++j) {
                   if (grid[i][j] == 2) { //rotten fruit
                       if (markRot(grid, i-1, j, visited)) { } // rot up
                       if (markRot(grid, i+1, j, visited)) { } // rot down
                       if (markRot(grid, i, j-1, visited)) { } // rot left
                       if (markRot(grid, i, j+1, visited)) { } // rot right
                   }
                }
            }
            visitedOranges = rot(grid);
            
            printGrid(grid);
            // System.out.printf("at the end of second : %d rotten-oranges= %d\n", seconds, visitedOranges);
            if (visitedOranges > rotted) {
                rotted = visitedOranges;
                
            }
            else {
                -- seconds;
                break;
            }
        }
        return visitedOranges == maxOranges ? seconds : -1;
    }
    private int rot(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; ++i) {
             for (int j = 0; j < grid[0].length; ++j) {
                 if (grid[i][j] == -1 || grid[i][j] == 2) {
                     grid[i][j] = 2;
                     ++count;
                 }
             }
        }
        return count;
    }
    
    private boolean markRot(int[][] grid, int i, int j, int[][] visited) {
        if (i < 0 || j < 0 || i > grid.length -1 || j > grid[0].length -1 || visited[i][j] == 1 || grid[i][j] != 1) return false;
        grid[i][j] = -1;
        visited[i][j] = 1;
        return true;
        
    }
    
    private void printGrid(int [][] grid) {
    //     for (int i = 0; i < grid[0].length; ++i) {
    //         for (int j = 0; j< grid[0].length; ++j) {
    //             System.out.printf(" %d ", grid[i][j]);
    //         }
    //         System.out.println("");
    //     }
    //     System.out.println("----------------X--------------");
    }
}
