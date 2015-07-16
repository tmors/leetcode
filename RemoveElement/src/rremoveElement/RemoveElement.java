package rremoveElement;
//2015-02-21

public class RemoveElement {

	/**
	 * @param args
	 */
	public static int removeElement(int[] A, int elem) {
		int len=A.length;
		int loc=0;
		for(int i=0;i<A.length;i++){
			if(A[i]==elem){
				len--;
				continue;
			}
			A[loc++]=A[i];
		}
		for(int i=0;i<len;i++){
			System.out.println(A[i]);
		}
        return len;
     
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]	A={4,5};
		System.out.println(removeElement(A,4));
	}
}
