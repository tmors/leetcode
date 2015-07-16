package MatrixChainOrder;

public class MatrixChainOrder {

	/**
	 * @param args
	 */
	public static int[][] MatrixChainOrder(int[] s,int[][] m){
		int[][] ans=new int[s.length][s.length];
		int n=s.length-1;
		for(int i=0;i<=n;i++){
			ans[i][i]=0;
		}
		for(int l=2;l<=n;l++){
			for(int q,i=1,j;i<=n-l+1;i++){
				j=i+l-1;
				ans[i][j]=Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++){
					q=ans[i][k]+ans[k+1][j]+s[i-1]*s[k]*s[j];
					if(q<ans[i][j]){
						ans[i][j]=q;
						m[i][j]=k;
					}
				}
			}
		}
		return ans;
	}
	public static void print_optimal(int[][] s,int i,int j){
		if(i==j){
			System.out.print("A"+i);
		}
		else {
			System.out.print("(");
			print_optimal(s,i,s[i][j]);
			print_optimal(s,s[i][j]+1,j);
			System.out.print(")");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p=new int[]{5,10,3,12,5,50,6};
		int[][] m=new int[p.length][p.length];
		int[][] s=MatrixChainOrder(p,m);
		for(int i=0;i<p.length;i++){
			s[0][i]=i;
			s[i][0]=i;
		}
		for(int i=0;i<p.length;i++){
			for(int j=0;j<p.length;j++){
				System.out.print(s[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=1;i<p.length;i++){
			for(int j=1;j<p.length;j++){
				System.out.print(m[i][j]+"\t");
			}
			System.out.println();
		}
		print_optimal(m,1,5);
		System.out.println(s[1]);
	}

}
