package com.dongyin.leetcodetree.tree;

/**特性篇二叉搜索树
 * 、直接基于 BST 的数据结构有 AVL 树，红黑树等等，拥有了自平衡性质
 * 中序树升序
 * @author dystart
 * @create 2022-04-13 0:49
 */
public class Solution2 {
    //因为中序遍历是升序
    int res=0,rank=0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return 0;
        kthSmallest(root.left,k);
        rank++;
        if (rank==k){
            res= root.val;
            return res;
        }
        kthSmallest(root.right,k);
        return res;
    }

//    查找排名为 k 的元素，当前节点知道自己排名第 m
////  如果 k < m，那说明排名第 k 的元素在左子树，所以可以去左子树搜索第 k 个元素。
//      3、如果 k > m，那说明排名第 k 的元素在右子树，所以可以去右子树搜索第 k - m - 1 个元素。



    //二叉树转累加树
    //节点 5，转化成累加树的话，比 5 大的节点有 6，7，8，加上 5 本身，
    // 所以累加树上这个节点的值应该是 5+6+7+8=26。
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    //降序打印累加
    int sum=0;
    public void  traverse(TreeNode root){
        if (root==null)return;
        traverse(root.right);
        sum+=root.val;
        root.val=sum;
        traverse(root.left);
    }
}
