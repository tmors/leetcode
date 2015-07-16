package isPowerOfTwo;
//20150707
public class IsPowerOfTwo {

	/**
	 * @param args
	 */
	public static boolean isPowerOfTwo(int n) {
		if(n<0){
			return false;
		}
        while(n>1){
        	if(n%2!=0){
        		return false;
        	}
        	else{
        		n=n/2;
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfTwo(1));
	}

}
