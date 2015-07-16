package pascalsTriangle;
//ac 2015-5-4
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	/**
	 * @param args
	 */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lst=new ArrayList<List<Integer>>();
        List<Integer> lst_fir=new ArrayList<Integer>();
        if(numRows==0){
        	return lst;
        }
        lst_fir.add(1);
        lst.add(lst_fir);
    	for(int i=1;i<numRows;i++){
    		List<Integer>  lst_inner=new ArrayList<Integer>();
    		lst_inner.add(1);
    		for(int j=1;j<i;j++){
    			lst_inner.add(lst.get(i-1).get(j-1)+lst.get(i-1).get(j));
    		}
    		lst_inner.add(1);
    		lst.add(lst_inner);
        }
    	return lst;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row=1;
		System.out.println(generate(row));
	}

}
