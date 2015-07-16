package subsets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subsets {

	/**
	 * @param args
	 */
	/*
	 * 复用自combinations
	 */
	public static int[] list2array(List lst){
		int loc=0;
		int[] s=new int[lst.size()];
		Iterator<Integer> itr=lst.iterator();
		while(itr.hasNext()){
			s[loc]=itr.next();
			loc++;
		}
		return s;
	}
    public static List<List<Integer>> combine(List<Integer> list) {
        int[] nums=list2array(list);
        List<List<Integer>> lst_sum=new ArrayList<List<Integer>>();
        List<Integer> lst=new ArrayList<Integer>();
        for(int j=1;j<=nums.length;j++){
        	for(int i=0;i<nums.length;i++){
	        	//把各参数含义注释出来，可复用在subset上
	        	//lst_sum存储所有的结果，lst存储单次的结果
	        	//s存储数组，本题中使用的是1，2，3，。。。n
	        	//k：从s中取出k个非降序list
	        	//i：从第i个数开始取数，用于DP
	        	Find(lst_sum,lst,nums,j,i);
	        }
        }
	        
        return lst_sum;
    }
    //Find并未检验 数组中后一个比前一个小的情况，复用在subsets时需要添加这一部分功能
    public static void Find(List<List<Integer>> lst_sum,List<Integer> lst,int[] s,int n,int begin){
    	lst.add(s[begin]);
    	if(n==1){
			List<Integer> lst_save=new ArrayList<Integer>();
			for(Iterator itr=lst.iterator();itr.hasNext();){
				lst_save.add((Integer) itr.next());
			}
			lst_sum.add(lst_save);
			lst.remove(lst.size()-1);
			return;
		}
    	for(int i=begin+1;i<s.length;i++){
    		Find(lst_sum,lst,s,n-1,i);
    	}
    	lst.remove(lst.size()-1);
    }
    /*本题内容
     * 
     */
    public static List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> lst=new ArrayList<Integer>();
        List<List<Integer>> lst_sum=new ArrayList<List<Integer>>();
        //k:取k个长度的list
        for(int k=1;k<=nums.length;k++){
        	for(int i=0;i<nums.length;i++){
            	//把各参数含义注释出来，可复用在subset上
            	//lst_sum存储所有的结果，lst存储单次的结果
            	//s存储数组，本题中使用的是1，2，3，。。。n
            	//k：从s中取出k个非降序list
            	//i：从第i个数开始取数，用于DP
            	Find(lst_sum,lst,nums,k,i);
            }
        }
        lst_sum.add(new ArrayList<Integer>(){});
        return lst_sum;
    }
   //由Combinations复用而来，需要增加check 后一个数比前一个数小的情况
   //感觉不能复用，注释掉重写一个
   //由原数组产生n个子数组，子数组为最长逆序数为0数组，再通过在子数组中产生答案，每次产生后将一部分删除（哈希？）
/*    public static void Find(List<List<Integer>> lst_sum,List<Integer> lst,int[] s,int n,int begin){
    	lst.add(s[begin]);
    	if(n==1){
			List<Integer> lst_save=new ArrayList<Integer>();
			for(Iterator itr=lst.iterator();itr.hasNext();){
				lst_save.add((Integer) itr.next());
			}
			lst_sum.add(lst_save);
			lst.remove(lst.size()-1);
			return;
		}
    	for(int i=begin+1;i<s.length;i++){
    		Find(lst_sum,lst,s,n-1,i);
    	}
    	lst.remove(lst.size()-1);
    }*/
    //由原数组产生n个子数组，子数组为最长逆序数为0数组
    public static List<List<Integer>> makelist(int[] nums){
    	List<Integer> lst=new ArrayList<Integer>();
    	List<List<Integer>> llst=new ArrayList<List<Integer>>();
    	for(int n:nums){
    		lst.add(n);
    	}
    	while(lst.size()!=0){
    		List<Integer> temp=new ArrayList<Integer>();
    		temp.add(lst.get(0));
    		lst.remove(0);
    		int len=lst.size();

			for(Iterator<Integer> itr=lst.iterator();itr.hasNext();){
				int i=itr.next();
				int last_val=temp.get(temp.size()-1);
				if(i>=last_val){
					temp.add(i);
					
				}
			}
			llst.add(temp);
    		/*while(i<len){
    			if(lst.get(i)>temp.get(temp.size()-1)){
    				temp.add(lst.get(i));
    				lst.remove(i);
    				len=
    			}
    		}*/
    	}
		return llst;
    }
    public static void gene_list(List<List<Integer>> lst){
    	
    }
    public static void print_list(List<List<Integer>> lst_sum){
    	for(Iterator itr=lst_sum.iterator();itr.hasNext();){
    		System.out.println(itr.next());
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums=new int[]{1,3,2,4};
		List<List<Integer>> lst_sum=makelist(nums);
		print_list(lst_sum);
		
	}

}
