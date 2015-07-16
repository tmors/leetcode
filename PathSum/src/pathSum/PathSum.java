package pathSum;
import javax.swing.tree.TreeNode;
//ac   booleanд��    TreeNodeΪ��
//2015-5-5
//ֱ����leetcodeд�����Ա�����Ҫ����TreeNode����jar��д��ֱ������
import leetcode.ListNode;
public class PathSum {

	/**
	 * @param args
	 */
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean flag=false;
        if(root==null){
            return flag;
        }
        if(root.left==null&&root.right==null){
            if(root.val==sum){
                return true;
            }
        }
        else{
            if(root.left!=null){
                root.left.val=root.left.val+root.val;
                flag=flag||hasPathSum(root.left,sum);
            }
            if(root.right!=null){
                root.right.val=root.right.val+root.val;
                flag=flag||hasPathSum(root.right,sum);
            }
        }
        return flag;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode lst = null;
		int[] s=new int[]{1,2,3,4};
		lst=lst.GenerateList(s);
		lst.PrintList(lst);
		
	}

}
