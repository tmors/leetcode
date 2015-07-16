package triangle;
//2015-02-18 236ms
//希望能够将二维数组换成List 或者vector
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Triangle {

	/**
	 * @param args
	 */
    static int minimumTotal(List<List<Integer>> triangle) {
/*		int sum=0,min=0,loc=0;
    	Iterator<List<Integer>> itr=triangle.iterator();
    	while(itr.hasNext()){
    		
    		List<Integer> lst=itr.next();
    		Iterator<Integer> itr2=lst.iterator();
    		min=lst.get(0);
//    		System.out.println("min is"+min);
    		if(lst.size()==1){
    			min=lst.get(0);
    			sum=sum+min;
    			System.out.println("min is "+min+"  and min loc is "+loc );
    			continue;
    		}
    		int temp1=lst.get(loc),temp2=lst.get(loc+1);
    		if(temp1>temp2){
    			loc=loc+1;
    			min=temp2;
    		}
    		if(temp1<temp2){
    			min=temp1;
    		}
    		
    		sum=sum+min;
    		System.out.println("min is "+min+"  and min loc is "+loc );
		}
    	System.out.println("this sum is  "+sum+"   ");
    	return sum;*/
/*    	   if (triangle.size() == 0) {
               return 0;
           }
           int min = 0, prev = 0, current = 0;
           int[] result = new int[triangle.size()];
           for (int i = 1; i < result.length; i++) {
               result[i] = Integer.MAX_VALUE;
           }
           result[0] = triangle.get(0).get(0);

           List<Integer> list;
           for (int i = 1; i < triangle.size(); i++) {
               list = triangle.get(i);
               prev = result[0];
               result[0] += list.get(0);
               for(int j = 1; j < list.size(); j++) {
                   current = result[j];
                   if (current > prev) {
                       result[j] = list.get(j) + prev;
                   } else {
                       result[j] += list.get(j);
                   }
                   prev = current;
               }
           }

           min = result[0];
           for (int i = 1; i < result.length; i++) {
               if (min > result[i]) {
                   min = result[i];
               }
           }
           System.out.println("min is"+min);
           return min;*/
  /*  	int row=triangle.size();
        int[][] dp=new int[row][row];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<row;i++){
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
        }
        for(int i=1;i<row;i++){
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        }
        for(int i=2;i<row;i++){
            for(int j=1;j<triangle.get(i).size()-1;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(row-1).size();i++){
            min=Math.min(min,dp[row-1][i]);
        }
        System.out.println("min is "+min);
        return min;
    	*/
    	int loc,i,j;
    	int row=triangle.size(),line=triangle.get(triangle.size()-1).size();
    	int min;
    	int[][] a = new int[row][line];
    	if(triangle.size()==1){
    		return triangle.get(0).get(0);
    	}
    	
    	a[0][0]=triangle.get(0).get(0);
    	a[1][0]=triangle.get(1).get(0)+a[0][0];
    	a[1][1]=triangle.get(1).get(1)+a[0][0];
    	if(triangle.size()==2){
    		return Math.min(a[1][0], a[1][1]);
    	}
    	for(i=2;i<row;i++){
    		for(j=1;j<triangle.get(i).size()-1;j++){
    			a[i][j]=Math.min(a[i-1][j-1],a[i-1][j])+triangle.get(i).get(j);
    		}
    		a[i][0]=a[i-1][0]+triangle.get(i).get(0);
    		a[i][j]=a[i-1][j-1]+triangle.get(i).get(triangle.get(i).size()-1);
    	}
    	for(j=1,min=a[i-1][0];j<a[i-1].length;j++){
    		min=Math.min(min, a[i-1][j]);
    	}
    	return min;
    }
    
    static void print(List<List<Integer>>triangle){
    		Iterator<List<Integer>> itr=triangle.iterator();
    		while(itr.hasNext()){
    			System.out.println(itr.next());
    		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<List<Integer>> temp_list=new ArrayList<List<Integer>>();
		List<Integer>	lstInt = new ArrayList<Integer>();
		int len=3;
		for(int i=0;i<len;i++){
			List<Integer> lstTemp=new ArrayList<Integer>();
			for(int j=0;j<=i;j++){
				int temp=(int)(Math.random()*10);
				lstTemp.add(temp);
				
			}
			triangle.add(lstTemp);
		}
		lstInt.add(-1);
		List<Integer>	lstInt2=new ArrayList<Integer>();
		lstInt2.add(3);
		lstInt2.add(2);
		List<Integer>	lstInt3=new ArrayList<Integer>();
		lstInt3.add(-3);
		lstInt3.add(1);
		lstInt3.add(-1);
		temp_list.add(lstInt);
		temp_list.add(lstInt2);
		temp_list.add(lstInt3);
		
		print(temp_list);
		System.out.println(minimumTotal(temp_list));
//		print(triangle);
//		System.out.println(minimumTotal(triangle));
	}

}
