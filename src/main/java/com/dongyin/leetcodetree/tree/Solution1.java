package com.dongyin.leetcodetree.tree;

import io.netty.util.internal.MacAddressUtil;

import javax.swing.text.EditorKit;

/**
 * 基操篇
 * BST二叉搜索树BST 中任意一个节点的左子树所有节点的值都小于该节点的值，
 * 右子树所有节点的值都大于该节点的值
 * 就可以在二叉树中做类似二分搜索的操作
 *
 * @author dystart
 * @create 2022-04-12 23:49
 */
public class Solution1 {

    //模板
    void BST(TreeNode root, int target) {
        if (root.val == target)
            // 找到目标，做点什么
            //小了，就在right上找，right是大的
            if (root.val < target)
                BST(root.right, target);
        if (root.val > target)
            BST(root.left, target);
    }


    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }





    //二叉搜索树的值
    public TreeNode searchBST(TreeNode root, int val) {
        if (root==null)return null;
        if (root.val==val)return root;
        if (root.val>val){
            return searchBST(root.left,val);
        }
        if (root.val<val){
            return searchBST(root.right,val);
        }
        return null;
    }


    //二叉树插入一个值
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //判断找个null位置进行插入
        if (root==null)return new TreeNode(val);
        if (root.val<val){
            //插到右树上面将原来的右树替换
            root.right=insertIntoBST(root.right,val);
        }
        if (root.val>val){
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }

    //删除一个元素,删除这个节点，这是难点。因为删除节点的同时不能破坏 BST 的性质
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null)return null;
        if (root.val==key) {
            //当前是root，root删了，返回删除之后的
            if (root.right == null && root.left == null) {
                return null;
            }
            if (root.right==null){
                return root.left;
            }
            if (root.left==null){
                return root.right;
            }
            //A 有两个子节点，麻烦了，为了不破坏 BST 的性质，
            // A 必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己
            if (root.right!=null&&root.left!=null){
                TreeNode min = getMin(root.right);
                root.val=min.val;
                root.right=deleteNode(root.right,min.val);
            }
        }
        if (root.val>key){
            root.left=deleteNode(root.left,key);
        }
        if (root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;
    }


    //获得子树的最小节点
    public TreeNode getMin(TreeNode treeNode){
        while (treeNode.left!=null){
            treeNode=treeNode.left;
        }
        return treeNode;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(String string) {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
