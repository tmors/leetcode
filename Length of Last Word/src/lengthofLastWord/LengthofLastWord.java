package lengthofLastWord;
//ac 2015-5-4
public class LengthofLastWord {

	/**
	 * @param args
	 */
    public static int lengthOfLastWord(String s) {
        int loc_fir=s.lastIndexOf(' ');
        String str=s.substring(loc_fir+1);
    	//û�пո�
        if(loc_fir==-1){
    		return s.length();
    	}
        //��βû�пո�
        if(loc_fir!=s.length()-1){
        	return str.length();
        }
        //��β�пո�
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
