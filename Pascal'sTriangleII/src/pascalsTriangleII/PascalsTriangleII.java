package pascalsTriangleII;
//ac 好像是昨天 2015-5-4
//ps 刷到一点钟的秘境，然后七点起来上班真累。。
//pps 今天在玩how-old
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

	/**
	 * @param args
	 */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lst=new ArrayList<List<Integer>>();
        List<Integer> lst_fir=new ArrayList<Integer>();
        if(rowIndex==0){
        	return lst_fir;
        }
        lst_fir.add(1);
        lst.add(lst_fir);
    	for(int i=1;i<rowIndex;i++){
    		List<Integer>  lst_inner=new ArrayList<Integer>();
    		lst_inner.add(1);
    		for(int j=1;j<i;j++){
    			lst_inner.add(lst.get(i-1).get(j-1)+lst.get(i-1).get(j));
    		}
    		lst_inner.add(1);
    		lst.add(lst_inner);
        }
    	return lst.get(rowIndex-1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row=0;
		System.out.println(getRow(row));
	}

}
