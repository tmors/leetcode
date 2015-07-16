package countPrimes;
//ac 这个方法比我的方法速度快多了
//20150707
public class CountPrimes {

	/**
	 * @param args
	 */
    public static boolean isPrimes(int n){
    	int i=2;
    	while(i<=Math.sqrt(n)){
    		if(n%i==0){
    			return false;
    		}
    		i++;
    	}
    	return true;
    }
    public static int countPrimes(int n) {
        int res = 0;
        boolean[] used = new boolean[n];
        for (int i = 2; i <= Math.sqrt(n); i++) {
         if (!used[i - 1]) {
            int temp = i * i;
            while (temp < n) {
                used[temp - 1] = true;
                temp += i;
            }
        }
        }
        for (int i = 2; i < n; i++) {
        if (!used[i - 1]) {
            res++;
        }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		System.out.println(countPrimes(10));
		long end=System.currentTimeMillis();
		long cost=end-start;
		System.out.println("time cost:"+cost);
	}

}
