public class Solution {
   
    public void gameOfLife(int[][] board) {
         int row=board.length;
         int col=board[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int live=computeLive(board,i,j);
                if((board[i][j]&1)==1&&(live==2||live==3)){
                    board[i][j]=3; //11
                }
                if((board[i][j]&1)==0&&(live==3)){
                    board[i][j]=2; //10
                }
            }
        }
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                board[i][j]>>=1;
            }
        }
        
    }
    
    public int computeLive( int[][]board,int i, int j){
        
        int row=board.length;
        int col=board[0].length;
        int live=0;
        for (int m=Math.max(0,i-1);m<=Math.min(i+1,row-1);m++){
            for(int n=Math.max(0,j-1);n<=Math.min(j+1,col-1);n++){
                live+=board[m][n]&1;
            }
        }
        live-=board[i][j]&1;
        return live;
    }
}