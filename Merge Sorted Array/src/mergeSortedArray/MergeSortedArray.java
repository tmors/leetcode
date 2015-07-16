package mergeSortedArray;
//2015-02-22  199ms


public class MergeSortedArray {
	/**
	 * @param args
	 */
	public static void merge(int A[], int m, int B[], int n) {
        int[] C=new int[m+n];
        int i=0,j=0,loc=0;
        while(i<m&&j<n){
        	if(A[i]<=B[j]){
            	C[loc++]=A[i];
            	i++;
            }
            else{
            	C[loc++]=B[j];
            	j++;
            }
        }
        if(i==m){
        	while(j<n){
        		C[loc++]=B[j++];
        	}
        }
        else if(j==n){
        	while(i<m){
        		C[loc++]=A[i++];
        	}
        }
        for(int i1=0;i1<loc;i1++){
        	A[i1]=C[i1];
        }
        for(int i2=0;i2<m+n;i2++){
            System.out.print(A[i2]+"  ");
        }
        System.out.println();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A=new int[7],B={1,2,3};

		A[0]=1;
		A[1]=1;
		A[2]=2;
		A[3]=3;
		merge(A,4,B,3);
	}

}
