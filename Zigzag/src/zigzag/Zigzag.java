package zigzag;
//accept 409ms
public class Zigzag {

	/**
	 * @param args
	 */
	public static String converse(String s, int nRows){
		String ans;
		int pos=0;
		char[] temp;
		temp=s.toCharArray();
		if(s.length()<=nRows || nRows==1){
			return s;
		}
		for(int i=0;i<s.length();i=i+2*(nRows-1)){
			temp[pos]=s.charAt(i);
			pos++;
		}
		for(int i=1;i<nRows-1;i++){
			int j=i;
			temp[pos]=s.charAt(i);
			pos++;
			while(j<s.length()){
				j=j+2*(nRows-1-i);
				if(j>=s.length())
					continue;
				temp[pos]=s.charAt(j);
				pos++;
				j=j+2*i;
				if(j>=s.length())
					continue;
				temp[pos]=s.charAt(j);
				pos++;
			}
		}
		for(int i=nRows-1;i<s.length();i=i+2*(nRows-1)){
			temp[pos]=s.charAt(i);
			pos++;
		}
		ans=String.valueOf(temp);
		System.out.println(ans);
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(converse("PAYPALISHIRING",6));
	}

}
