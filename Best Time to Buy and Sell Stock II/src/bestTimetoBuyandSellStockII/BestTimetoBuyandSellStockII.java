package bestTimetoBuyandSellStockII;
//ac 2015-4-19
//注意不要使用递归，会导致time limited exceed
public class BestTimetoBuyandSellStockII {

	/**
	 * @param args
	 */
    public static int maxProfit(int[] prices) {
		int ans=0,diff;
		for(int i=0;i<prices.length-1;i++){
			diff=prices[i+1]-prices[i];
			ans+=diff>0?diff:0;
		}
		return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s=new int[]{3,4,7,5};
		System.out.println(maxProfit(s));
	}

}
