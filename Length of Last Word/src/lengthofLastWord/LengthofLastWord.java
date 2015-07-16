package lengthofLastWord;
//ac 2015-5-4
public class LengthofLastWord {

	/**
	 * @param args
	 */
    public static int lengthOfLastWord(String s) {
        int loc_fir=s.lastIndexOf(' ');
        String str=s.substring(loc_fir+1);
    	//没有空格
        if(loc_fir==-1){
    		return s.length();
    	}
        //结尾没有空格
        if(loc_fir!=s.length()-1){
        	return str.length();
        }
        //结尾有空格
        else{
        	return lengthOfLastWord(s.substring(0,loc_fir));

        }
      
        
    }
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String str="  ";
		System.out.println(lengthOfLastWord(str));
	}

}
