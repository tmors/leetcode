package uniqueBinarySearchTrees2;
//20150706 源码中每次都乘了，可以通过乘一般然后乘以2，加上奇偶判断一下，可以适当减小复杂度
public class UniqueBinarySearchTrees2 {

	/**
	 * @param args
	 */
	public static int sum(int[] s,int len){
		int i=0,sum=0;
		while(i<len){
			sum=sum+s[i]*s[len-i-1];
			i++;
		}
		return sum;
	}
	public static int numTrees(int n) {
		int[] array=new int[30];
		array[0]=1;
		array[1]=1;
		int i=2;
		while(i<=n){
			array[i]=sum(array,i);
			i++;
		}
		return array[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		System.out.println(numTrees(n));
	}

}
