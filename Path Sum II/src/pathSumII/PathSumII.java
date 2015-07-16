package pathSumII;
//20150628
//ps.�ոչ���0�㣬��Ȼ����627����
/*
 * 1.���Ȳ������е�·��list
 * 2.Ȼ�����е�list�ĺ���sum�Ƚϣ���ͬ��������һ������list���棬�������������list������ͬ��ɾ�������Բ���һ�£�
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PathSumII {

	/**
	 * @param args
	 */
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> lst=new ArrayList<List<Integer>>();
    	List<List<Integer>> ans=new ArrayList<List<Integer>>();
    	if(root==null){
    		return lst;
    	}
    	all_list(lst,root);
    	for(Iterator<List<Integer>> itr=lst.iterator();itr.hasNext();){
    		int sum_list=0;
    		
    		for(Iterator<Integer> itr_sub=itr.next().iterator();itr_sub.hasNext();){
    			sum_list=sum_list+itr_sub.next();
    		}
    		if(sum_list!=sum){
    			itr.remove();
    		}
    	}
        return lst;
    }
    //����root�µ�����·��
    public static List<List<Integer>> all_list(List<List<Integer>> lst,TreeNode root){
    	List<List<Integer>> list_left=new ArrayList<List<Integer>>(),list_right=new ArrayList<List<Integer>>();
    	if(root.left==null&&root.right==null){
    		List<Integer> back=new ArrayList<Integer>();
    		back.add(root.val);
    		lst.add(back);
    		return lst;
    	}
    	if(root.left!=null){
    		list_left=all_list(list_left,root.left);
    		for(Iterator<List<Integer>> itr=list_left.iterator();itr.hasNext();){
    			itr.next().add(0, root.val);
    		}
    	}
    	if(root.right!=null){
    		list_right=all_list(list_right,root.right);
    		for(Iterator<List<Integer>> itr=list_right.iterator();itr.hasNext();){
    			itr.next().add(0, root.val);
    		}
    	}
    	for(Iterator<List<Integer>> itr=list_left.iterator();itr.hasNext();){
    		lst.add(itr.next());
    	}
    	for(Iterator<List<Integer>> itr=list_right.iterator();itr.hasNext();){
    		lst.add(itr.next());
    	}
    	return lst;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> lst=new ArrayList<List<Integer>>();
		TreeNode tr=new TreeNode(1);
		tr.left=new TreeNode(2);
		tr.right=new TreeNode(3);
		tr.left.left=new TreeNode(4);
		tr.left.right=new TreeNode(5);
		tr.right.right=new TreeNode(4);
		System.out.println(pathSum(tr,7));
	}

}
