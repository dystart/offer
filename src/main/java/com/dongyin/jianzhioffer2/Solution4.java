package com.dongyin.jianzhioffer2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dystart
 * @create 2022-05-10 17:46
 */
public class Solution4 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }





    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }


    public TreeNode build(int[] preorder, int perStart,int perNed,
                          int[] inorder,int inStart,int inEnd){
        if (perStart > perNed) {
            return null;
        }
        //找到前序的root在中序当中的位置
        int rootVal = preorder[perStart];
        int index=0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i]==rootVal){
                index=i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        //leftIndex代表左边有多少元素是左的子树，在先序遍历中就有几个是左子树
        int leftIndex = index - inStart;

        root.left=build(preorder, perStart+1,perStart+leftIndex,
                inorder,inStart,index-1);
        root.right=build(preorder,perStart+leftIndex+1,perNed,
                inorder,index+1,inEnd);
        return root;
    }



    public TreeNode mirrorTree(TreeNode root) {
        TreeNode treeNode = mirrorTree(root.left);
        if (root==null){
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right=left;
        root.left=right;
        return root;
    }


    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

}
