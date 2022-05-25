class Solution {
    int arR = 0;
    int arC = 0;
    boolean [][] visited;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.arR = image.length;
        this.arC = image[0].length;
        visited = new boolean[arR][arC];
        fill(image, sr, sc, newColor, image[sr][sc], true);
        return image;
    }
    private boolean visited(int i, int j) {
        if (visited[i][j] == true)
            return true;
        return false;
    }
    
    private void fill(int[][] image, int i, int j, int newColor, int oldColor, boolean input) {
        if (i < 0 || i >= arR || j < 0 || j >= arC ) return;
        if (visited(i,j) == true) return;
        visited[i][j] = true;
        if (input == true) {
            image[i][j] = newColor;
        }
        else {
            if (image[i][j] != oldColor) return;
            image[i][j] = newColor;
        }
        // check up
        fill (image, i-1, j, newColor, oldColor, false);
        // check down
        fill(image, i+1, j, newColor, oldColor, false);
        // check left
        fill(image,i, j-1, newColor, oldColor, false);
        // check right
        fill (image, i, j+1, newColor, oldColor, false);
    }
}
