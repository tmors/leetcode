package factorialTrailingZeroes;

public class FactorialTrailingZeroes {

	/**
	 * @param args
	 */
    public static int trailingZeroes(int n) {
    	int count_five,count_ten=n/10,temp=0;
    	int ans;
    	int i=0,flag=0;
    	
    	while(n>0){
    		i=n%5;
    		n=n/5;
    		if(i==0){
    			flag++;
    		}
    		else break;
    	}
    	ans=count_ten+flag;
    	return ans;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=30,ans=1;
		long  ans1 = 1;
		System.out.println(trailingZeroes(n));
//		for(int i=1;i<=n;i++){
//			ans1=ans1*i;
//		}
//		System.out.println(ans1);
	}

}
