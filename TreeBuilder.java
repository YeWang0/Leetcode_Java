/**
 * Created by yvan on 9/10/16.
 */

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Construct Binary Tree from Inorder and Postorder Traversal
public class TreeBuilder {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode node=null;
        node=buildNode(inorder, postorder, node);
        return node;
    }
    public TreeNode buildNode(int[] inorder, int[] postorder,TreeNode node){
        int n=postorder.length;
        // System.out.println("n:="+n);
        if(n==0){
            node=null;
            return null;
        }
        int mid=postorder[n-1];
        node=new TreeNode(mid);
        // System.out.println("node:="+node.val);
        if(n==1){
            return node;
        }
        int index=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==mid){
                index=i;
            }
        }
        // System.out.println("idx:="+index);
        if(index==0){
            node.left=null;
            node.right=buildNode(Arrays.copyOfRange(inorder, index+1, n),Arrays.copyOfRange(postorder, index, n-1),node.right);
        }
        else if(index==n-1){
            node.right=null;
            node.left=buildNode(Arrays.copyOfRange(inorder, 0, index),Arrays.copyOfRange(postorder, 0, index),node.left);
        }else{
            node.left=buildNode(Arrays.copyOfRange(inorder, 0, index),Arrays.copyOfRange(postorder, 0, index),node.left);
            node.right=buildNode(Arrays.copyOfRange(inorder, index+1, n),Arrays.copyOfRange(postorder, index, n-1),node.right);
        }
        return node;
    }
}
