package combinations;
//ac 2015-5-24  
//20150624 �����е㿴����(��������)...
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinations {

	/**
	 * @param args
	 */
    public static List<List<Integer>> combine(int n, int k) {
        int[] s=new int[n];
        for(int i=0;i<s.length;i++){
        	s[i]=i+1;
        }
        List<Integer> lst=new ArrayList<Integer>();
        List<List<Integer>> lst_sum=new ArrayList<List<Integer>>();
       
        for(int i=0;i<s.length;i++){
        	//�Ѹ���������ע�ͳ������ɸ�����subset��
        	//lst_sum�洢���еĽ����lst�洢���εĽ��
        	//s�洢���飬������ʹ�õ���1��2��3��������n
        	//k����s��ȡ��k���ǽ���list
        	//i���ӵ�i������ʼȡ��������DP
        	Find(lst_sum,lst,s,k,i);
        }
        return lst_sum;
    }
    //Find��δ���� �����к�һ����ǰһ��С�������������subsetsʱ��Ҫ�����һ���ֹ���
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
    public static void print_list(List<List<Integer>> lst_sum){
    	for(Iterator itr=lst_sum.iterator();itr.hasNext();){
    		System.out.println(itr.next());
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> lst_sum=combine(4,3);
		print_list(lst_sum);
	}

}
