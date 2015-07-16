package searchInsertPosition;
//2015-03-25
//没有用到二叉树，建议以后再来改成二叉树的
//还有另外一个
public class SearchInsertPosition {

	/**
	 * @param args
	 */
    public static int searchInsert(int[] A, int target) {
    	
        for(int i=0;i<A.length;i++){
        	if(A[i]>=target){
        		return i;
        	}
        }
        return A.length;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={};
		System.out.println(searchInsert(A,1));
	}

}
