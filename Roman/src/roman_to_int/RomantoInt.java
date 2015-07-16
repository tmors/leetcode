package roman_to_int;
//2015-02-13 315ms
public class RomantoInt {

	/**
	 * @param args
	 */
    public static int romanToInt(String s) {
    	int len=s.length();
    	int[] invert = new int[3999];
    	int sum=0;
    	char temp;
    	for(int i=0;i<len;i++){
    		temp=s.charAt(i);
	    		switch(temp){
	    		case 'I':
	    			invert[i]=1;
					sum=sum+1;
					break;
				case 'V':
					invert[i]=5;
					sum=sum+5;
					break;
				case 'X':
					invert[i]=10;
					sum=sum+10;
					break;
				case 'L':
					invert[i]=50;
					sum=sum+50;
					break;
				case 'C':
					invert[i]=100;
					sum=sum+100;
					break;
				case 'D':
					invert[i]=500;
					sum=sum+500;
					break;
				case 'M':
					invert[i]=1000;
					sum=sum+1000;
					break;
    		}	
    	}
    	for(int i=0;i<len-1;i++){
    		if(invert[i]<invert[i+1]){
    			sum=sum-2*invert[i];
    		}
    	}
    	return sum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("MMCVC"));
	}

}
