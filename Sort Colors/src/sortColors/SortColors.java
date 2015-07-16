package sortColors;
//2015-03-11 181ms
public class SortColors {

	/**
	 * @param args
	 */
    public static void sortColors(int[] A) {
        int[] B=new int[A.length];
        int[] C=new int[3];
        for(int i=0;i<A.length;i++){
        	C[A[i]]=C[A[i]]+1;
        }
        for(int i=1;i<3;i++){
        	C[i]=C[i]+C[i-1];
        }
        for(int i=A.length-1;i>=0;i--){
        	B[--C[A[i]]]=A[i];
        }
        for(int i=0;i<A.length;i++){
        	A[i]=B[i];
        }
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={};
		int[] B=new int[A.length];
	/*	B=sortColors(A);
		for(int i=0;i<B.length;i++){
			System.out.print(B[i]+"  ");
		}*/
	}

}
