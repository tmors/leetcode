package removeDuplicates;
//2015-02-21 271ms 

public class RemoveDuplicates {

	/**
	 * @param args
	 */
    public static int removeDuplicates(int[] A) {
    	/*  if(A.length==0) return 0;
          int insertIndex = 1;
          for(int i=1;i<A.length;i++){
              if(A[i]!=A[insertIndex-1]){
                  A[insertIndex++] = A[i];
              }
          }
          return insertIndex;*/
    	//参考以上代码
    	
    	int len=A.length,loc=0;
    	int[] B=new int[A.length];
    	
    	for(int i=0;i<A.length-1;i++){
    		B[loc]=A[i];
    		if(B[loc]==A[i+1]){
    			len--;
    			continue;
    		}
    		else if(i==A.length-2){
    			B[loc+1]=A[i+1];
    		}
    		loc++;
    	}
    	
    	return len;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,1,2};
		removeDuplicates(A);
	}

}
