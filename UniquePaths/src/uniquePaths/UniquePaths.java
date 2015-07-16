package uniquePaths;
//ac 2015-4-23
public class UniquePaths {

	/**
	 * @param args
	 */
    public static int uniquePaths(int m, int n) {
		int i=0;
		i=cnk(m+n-2,Math.min(m, n)-1);
        return i;
//以上是第一种做法，我认为值为排列组合问题，但是没有通过，有数据溢出，不清楚原因
//我怀疑是cnk函数有错误
//问题在于运行cnk时，数据不断增大，除数还未除完时有可能发生溢出
//解决：先除后乘，为避免小数 用float强制转换int
//新的问题：float存在精度问题，计算结果与答案之间差了1
//    	if(m==1||n==1){
//    		return 1;
//    	}
//    	return uniquePaths(m-1,n)+uniquePaths(m,n-1);
//以上第二种做法，用的是分治，但是超时了，暂时不清楚对错
//    	int[][] s=new int[m+1][n+1];
//    	s[m][n]=1;
//    	for(int i=m;i>=1;i--){
//    		for(int j=n;j>=1;j--){
//    			if(i==m&&j==n){
//    				s[i][j]=1;
//    				continue;
//    			}
//    			if(i==m){
//    				s[i][j]=s[i][j+1];
//    				continue;
//    			}
//    			if(j==n){
//    				s[i][j]=s[i+1][j];
//    				continue;
//    			}
//    			s[i][j]=s[i+1][j]+s[i][j+1];
//    		}
//    	}
//    	return s[1][1];
 //动态规划终于ac了,不过时间略长，而且不清楚第一种为什么不过
    }
    public static int cnk(int n,int k){
    	int a=1;
    	float s=1;
    	for(int i=1;i<=k;i++){
    		a=a/i*n;
    		n--;
    	}
    	return a;
    }
    public static int compare(int m,int n){
    	int[][] s=new int[m+1][n+1];
    	s[m][n]=1;
    	for(int i=m;i>=1;i--){
    		for(int j=n;j>=1;j--){
    			if(i==m&&j==n){
    				s[i][j]=1;
    				continue;
    			}
    			if(i==m){
    				s[i][j]=s[i][j+1];
    				continue;
    			}
    			if(j==n){
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
		System.out.println(uniquePaths(5,5));
		System.out.println(compare(19,13));
	}

}
