package plusOne;

public class PlusOne {

	/**
	 * @param args
	 */
	public static int[] plusOne(int[] digits) {
        
        for(int i=digits.length-1;i>=0;i--){
        	if(digits[i]<9){
        		digits[i]=digits[i]+1;
        		return digits;
        	}
        	else{
        		digits[i]=0;
        		if(i==0){
        			int[] out=new int[digits.length+1];
        			out[0]=1;
        			return out;
        		}
        	}
        }
		return digits;        	 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits={9,9,9},out=new int[digits.length+1];
		System.out.println(out=plusOne(digits));
		for(int i=0;i<out.length;i++){
			System.out.print(out[i]+"  ");
		}
	}
}
