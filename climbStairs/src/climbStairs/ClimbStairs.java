package climbStairs;

public class ClimbStairs {

	/**
	 * @param args
	 */
    public static int climbStairs(int n) {
        
        int[] A=new int[n+1];
        A[0]=1;
        A[1]=1;
        
        for(int i=2;i<=n;i++){
        	A[i]=A[i-1]+A[i-2];
        }
        return A[n];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(1));
	}

}
