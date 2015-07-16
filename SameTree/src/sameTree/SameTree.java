package sameTree;
//2015-3-21  
public class SameTree {

	/**
	 * @param args
	 */
	public static class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean left_ans=true,right_ans=true;
    	if(p==null&&q==null){    		//p,q�ж���˳��һ��Ҫ��ȷ����Ϊ�ڴ���һ��Ϊ��ʱ����ȡval��ֵ��
        	return true;				//���ж��Ƿ�Ϊ�գ����ж��Ƿ�һ��Ϊ�գ����ж�ֵ�Ƿ���ͬ��������left��right�ж�
        }
        else if((p==null||q==null)||p.val!=q.val){
        	return false;
        }
        else if(p.val==q.val)
        {
        	left_ans=isSameTree(p.left,q.left);
        	right_ans=isSameTree(p.right,q.right);
        }
        
        	
    	
        if(left_ans==true&&right_ans==true){
        	return true;
        }
        else
        	return false;
     
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode p = new TreeNode(1);
		TreeNode q=new TreeNode(1);
	    int[] A={6,5};
	    int[] B={6,5,5,4};
	    for(int i=0;i<A.length;i++){
	    	p.left=new TreeNode(A[i++]);
	    	p.right=new TreeNode(A[i]);
	    }
	    for(int i=0;i<B.length;i++){
	    	q.left=new TreeNode(B[i++]);
	    	q.right=new TreeNode(B[i]);
	    }
		System.out.println(isSameTree(p,q));
	}

}
