package factorialTrailingZeroes;

public class FactorialTrailingZeroes {

	/**
	 * @param args
	 */
    public static int trailingZeroes(int n) {
    	int i=0;
    	int temp_n=n;
    	if(n<5){
    		return i;
    	}
    	while(temp_n%5==0){
    		i=i+1;
    		temp_n=temp_n/5;
    	}
    	return trailingZeroes(n-1)+i;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(1808548329));
	}

}
