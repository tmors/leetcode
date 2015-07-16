package addBinary;
//20150618
public class AddBinary {

	/**
	 * @param args
	 */
	public static String addBinary(String a, String b) {
		int flag=0;
		int len1=a.length(),len2=b.length();
		String ans=new String();
		
		while(len1>0||len2>0){
			int bit_val1,bit_val2;
			if(len1>0){
				bit_val1=Integer.parseInt(String.valueOf(a.charAt(len1-1)));
			}
			else{
				bit_val1=0;
			}
			if(len2>0){
				bit_val2=Integer.parseInt(String.valueOf(b.charAt(len2-1)));
			}
			else{
				bit_val2=0;
			}
			ans=ans+String.valueOf((bit_val1+bit_val2+flag)%2);
			if(bit_val1+bit_val2+flag>=2){
				flag=1;
			}
			else{
				flag=0;
			}
			len1=len1-1;
			len2=len2-1;
		}
		
		ans=ans+String.valueOf(flag);
		ans=new String(new StringBuffer(ans).reverse());
		ans=DuplicateDel(ans);
        return ans;	
    }
	public static String DuplicateDel(String str){
		int loc=0;
		while(loc<str.length()){
			if(str.charAt(loc)=='0'){
				loc++;
			}
			else{
				break;
			}
		}
		if(loc==str.length()){
			return "0";
		}
		return str.substring(loc, str.length());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="0",b="0";
		String ans=addBinary(a,b);
		System.out.println(ans);
	}

}
