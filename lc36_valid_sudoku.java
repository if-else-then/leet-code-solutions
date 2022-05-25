class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> uniqNum = new HashSet<>();
        // check all rows for duplicacy
        for (int i=0; i<9; i++)
        {
            uniqNum.clear();
            for (int j=0; j<9; j++)
            {
                if (uniqNum.contains(board[i][j])) return false;
                if(board[i][j] != '.') uniqNum.add(board[i][j]);
            }
        }
        
        // check all columns for duplicacy
        for (int j=0; j<9; j++)
        {
            uniqNum.clear();
            for (int i=0; i<9; i++)
            {
                if (uniqNum.contains(board[i][j])) return false;
                if(board[i][j] != '.') uniqNum.add(board[i][j]);
            }
        }
        
        // check sub-sudokus
        // int rowB=0, rowE=3, colB=0, colE=3;
        for (int rowB=0; rowB<9; rowB += 3)
        {
            for (int colB=0; colB<9; colB += 3)
            {
                uniqNum.clear();
                for (int i=rowB; i<rowB+3; i++)
                {
                    for (int j=colB; j<colB+3; j++)
                    {
                        if (uniqNum.contains(board[i][j])) return false;
                        if(board[i][j] != '.') uniqNum.add(board[i][j]);
                    }
                }
                // colB = colE;
                // colE *= (colT+1);
            }
            // rowB = rowE;
            // rowE *= (rowT+1);
        }
        
        return true;
    }
}
