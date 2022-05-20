package com.dongyin.leetcodetree.tree;

import java.util.ArrayList;
import java.util.List;

/**后序篇
 * 那么换句话说，一旦你发现题目和子树有关，\
 * 那大概率要给函数设置合理的定义和返回值，在后序位置写代码了
 * @author dystart
 * @create 2022-04-13 18:03
 */
public class Solution4 {

    //寻找重复的子树
    //以我为根的这棵二叉树（子树）长啥样？
    //
    //2、以其他节点为根的子树都长啥样？
    //后序遍历,想要知道以自己为根节点的子树,就先知道左右子树
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        return null;
    }

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 先算出左右子树有多少节点
        int left = count(root.left);
        int right = count(root.right);
        /* 后序遍历代码位置 */
        // 加上自己，就是整棵二叉树的节点数
        int res = left + right + 1;
        return res;
    }





    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode=dummyNode;
        for (Integer re : res) {
            currNode.right=new TreeNode(re);
            currNode=currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

}
