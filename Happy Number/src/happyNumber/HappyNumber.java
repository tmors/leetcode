package happyNumber;
//20150618
//ps.那个页面好像是我做的  (￣▽￣)" 细思极恐
import java.util.HashMap;

public class HappyNumber {

	/**
	 * @param args
	 */
	public static int happynum(int i){
		int sum=0;
		while(i!=0){
			sum=sum+(i%10)*(i%10);
			i=i/10;
		}
		return sum;
	}
    public static boolean isHappy(int n) {
    	HashMap hm=new HashMap();
    	while(n!=1){
    		hm.put(String.valueOf(n),String.valueOf(n));
    		n=happynum(n);
    		if(hm.get(String.valueOf(n))!=null){
    			return false;
    		}
    	}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isHappy(12);
	}

}
