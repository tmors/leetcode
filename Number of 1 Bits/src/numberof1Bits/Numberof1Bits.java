package numberof1Bits;
//2015-03-26
public class Numberof1Bits {

	/**
	 * @param args
	 */
    public static int hammingWeight(int n) {
        int[] A=new int[32];
        int i=0,count=0,ans=0;
        if(n<0){
        	n+=Integer.MAX_VALUE+1;
        	ans=hammingWeight(n)+1;
        	return ans;
        }
        while(n!=0){
            A[i++]=(int) (n%(long)2);
            n=n/2;
        }
        for(int j=0;j<=31;j++){
            if(A[j]==1||A[j]==-1){
                count++;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=Integer.MAX_VALUE;
		System.out.println(hammingWeight(2*n+1));
	}

}
