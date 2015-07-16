package majorityElement;

import java.util.HashMap;
//ac 2015-4-19  就这样ac了，简直了，more than 原来是大于（不包括等于的）
//get重复了几次不过也懒得改了 
//第三十九个，刷几个easy过了40吧
public class MajorityElement {

	/**
	 * @param args
	 */
    public static int majorityElement(int[] num) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<num.length;i++){
        	if(hm.get(num[i])==null){
        		hm.put(num[i], 1);
        	}
        	else{
        		hm.put(num[i],hm.get(num[i])+1);
        	}
        	if(hm.get(num[i])>num.length/2){
        		return num[i];
        	}
        }
		return 0;  
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s=new int[]{6,5,5};
		System.out.println(majorityElement(s));
	}

}
