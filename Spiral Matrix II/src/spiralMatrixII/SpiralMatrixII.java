package spiralMatrixII;
//ac 20150624 第61个，虽然大多数是easy
public class SpiralMatrixII {

	/**
	 * @param args
	 */
    public static int[][] generateMatrix(int n) {
    	if(n==0){
    		return new int[][]{};
    	}
    	//以direct_x,direct_y记录下一步要进行的方向
    	//x记录行的变化，y记录列的变化
		int direct_x=0,direct_y=1;
		int[][] gen=new int[n][n];
		int cur_x=0,cur_y=0;
		gen[0][0]=1;
		int val=2;
		int times=n*n-1;
		while(times>0){
			cur_x=cur_x+direct_x;
			cur_y=cur_y+direct_y;
			if(within(cur_x,cur_y,gen)){
				gen[cur_x][cur_y]=val++;
				times--;
			}
			else{
				cur_x=cur_x-direct_x;
				cur_y=cur_y-direct_y;
				if(direct_x==0){
					//行不发生变化
					if(direct_y==1){
						//列向右移一格
						direct_x=1;
						direct_y=0;
						continue;
					}
					if(direct_y==-1){
						//列向左移一格
						direct_x=-1;
						direct_y=0;
						continue;
					}
				}
				if(direct_y==0){
					//列不发生变化
					if(direct_x==1){
						//行向下移动一格
						direct_x=0;
						direct_y=-1;
						continue;
					}
					if(direct_x==-1){
						//行向上移动一格
						direct_x=0;
						direct_y=1;
						continue;
					}
				}
			}
		}
		return gen;
    }
    public static boolean within(int cur_x,int cur_y,int[][] gen){
    	//判断当前坐标是否为有效坐标
    	if(cur_x>=0&&cur_x<gen.length&&cur_y>=0&&cur_y<gen.length&&gen[cur_x][cur_y]==0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix=generateMatrix(0);
		for(int[] x:matrix){
			for(int y:x){
				System.out.print(y+" ");
			}
			System.out.println();
		}
	}

}
