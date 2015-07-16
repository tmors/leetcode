package Reverse_int;

public class reverse_int {

	/**
	 * @param args
	 */
	
	    public static int reverse(int x) {
	        int sum=0;
	        while(x!=0){
	        	if(Math.abs(sum)>=Integer.MAX_VALUE/10) //提前一位判断是否会溢出
	        	{
	        		return 0;
	        	}
	        	sum=sum*10+x%10;
	        	x=x/10;
	        }
	        return sum;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=2147483647;

		System.out.println(0x7fffffff);
		System.out.println(0x80000000);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(reverse(x));
	}

}
