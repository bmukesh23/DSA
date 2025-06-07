class Solution {
    private int rows;
    private int cols;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(dfs(0, r, c, word, board)){
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(int ind, int row, int col, String word, char[][] board){
        if(ind == word.length()) return true;

        if(row < 0 || col < 0 || row >= rows || col >= cols 
            || visited[row][col] || board[row][col] != word.charAt(ind)){
            return false;
        }

        visited[row][col] = true;

        boolean found = dfs(ind + 1, row - 1, col, word, board) 
                        || dfs(ind + 1, row + 1, col, word, board) 
                        || dfs(ind + 1, row, col - 1, word, board) 
                        || dfs(ind + 1, row, col + 1, word, board);

        visited[row][col] = false;
        return found;
    }
}