package ComputeArea;

public class computeArea {

	/**
	 * @param args
	 */
	public static void swap(int[] s,int i,int j){
		int temp=s[i];
		s[i]=s[j];
		s[j]=temp;
	}
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int[] hor=new int[4],ver=new int[4];
        hor[0]=A;hor[1]=C;hor[2]=E;hor[3]=G;
        ver[0]=B;ver[1]=D;ver[2]=F;ver[3]=H;
        int i=0;
        while(i<4){
        	for(int j=i+1;j<4;j++){
        		if(hor[i]>hor[j]){
        			swap(hor,i,j);
        		}
        		if(ver[i]>ver[j]){
        			swap(ver,i,j);
        		}
        	}
        	i++;
        }
       int v=ver[2]-ver[1],h=hor[2]-hor[1];
       int ans;
       if((E<=C&&E>=A)&&(F<=D&&F>=B)||((G<=C&&G>=A)&&(H<=D&&H>=B))){
    	   ans=v*h;
       }
       else{
    	   ans=0;
       }
       int area=(C-A)*(D-B)+(G-E)*(H-F);
       return area-ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=computeArea(-2, -2, 2, 2, -2, -2, 2, 2);
		System.out.println(n);
	}

}
