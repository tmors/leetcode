package uniquePathsII;
//ac 2015-4-23
//把1的代码拿过来用一下就好了
public class UniquePathsII {

	/**
	 * @param args
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		int col=obstacleGrid[0].length,row=obstacleGrid.length;
		int[][] s=new int[row+1][col+1];
		for(int i=row;i>=1;i--){
			for(int j=col;j>=1;j--){
				if(obstacleGrid[i-1][j-1]==1){
					s[i][j]=0;
					continue;
				}
				if(i==row&&j==col){
					s[i][j]=1;
					continue;
				}
				if(i==row){
					s[i][j]=s[i][j+1];
					continue;
				}
				if(j==col){
					s[i][j]=s[i+1][j];
					continue;
				}
				s[i][j]=s[i+1][j]+s[i][j+1];
			}
		}
		return s[1][1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
