package leetcode;

public class matrixflip {
    public int matrixScore(int[][] grid) {
        int row= grid.length;
        int col= grid[0].length;

        //  There must be 1 at the starting of every row
        for(int r=0; r<row; r++){

            if(grid[r][0] == 0){
                grid= swapRow( r, grid );
            }
        }

        //  There must be max 1's in the col.
        for(int c=0; c< col; c++){
            if(countCol1(c, grid) <= (grid.length)/2){
                grid= swapCol( c, grid );
            }

        }

        int sum= 0;
        for(int r=0; r<row; r++){

            String s= "";
            for(int i: grid[r]){
                s+= Integer.toString(i);
            }
            sum+= Integer.parseInt(s, 2);
        }
        return sum;
    }

    //  Count no. of 1's in every column
    public int countCol1(int col, int[][] grid){
        int ones= 0;
        for(int i= 0; i<grid.length; i++){

            if(grid[i][col] == 1){
                ones++;
            }
        }

        return ones;
    }

    //  Swap 1's with 0's in row
    public int[][] swapRow(int row, int[][] grid){

        for(int index= 0; index<grid[row].length; index++){

            if(grid[row][index] == 0){
                grid[row][index]= 1;
            }

            else if(grid[row][index] == 1){
                grid[row][index]= 0;
            }

        }

        return grid;
    }

    //  Swap 1's with 0's in column
    public int[][] swapCol(int col, int[][] grid){

        for(int i= 0; i<grid.length; i++){

            if(grid[i][col] == 0){
                grid[i][col]= 1;
            }

            else if(grid[i][col] == 1){
                grid[i][col]= 0;
            }

        }

        return grid;
    }
}