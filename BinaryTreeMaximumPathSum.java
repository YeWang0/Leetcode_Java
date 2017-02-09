/**
 * Created by yvan on 2/9/17.
 */

public class BinaryTreeMaximumPathSum {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }
    public int findMax(TreeNode node) {
        if(node==null)return 0;
        int left=findMax(node.left);
        int right=findMax(node.right);
        max=Math.max(node.val+left+right,max);
        int pathVal=Math.max(node.val+left,node.val+right);
        return pathVal>0?pathVal:0;
    }
}
