package com.dongyin.leetcodetree.tree;

import java.util.LinkedList;
import java.util.List;

/**二叉搜索树构造篇
 * @author dystart
 * @create 2022-04-13 12:27
 */
public class Solution3 {


    //加备忘录,因为递归和for循坏可能重复
    int[][] memo;

    //n 输出1到n的所以二叉树构造结果有几种
    public int numTrees(int n) {
        memo=new int[n+1][n+1];
        return count(1,n);
    }

    //计算[lo,hi]的二叉树有多少种
    int count(int lo,int hi){
//    显然当lo > hi闭区间[lo, hi]肯定是个空区间，也就对应着空节点 null，虽然是空节点，但是也是一种情况
        if (lo>hi){
            return 1;
        }
        if (memo[lo][hi]!=0){
            return memo[lo][hi];
        }
        int res=0;
        //计算出左右子树的个数，相乘为总个数
        for (int i = lo; i <=hi; i++) {
            int left=count(lo,i-1);
            int right=count(i+1,hi);
            res+=left*right;
        }
        //递归完的结果当如,下次循坏要用
        memo[lo][hi]=res;
        return res;
    }



//    1、穷举root节点的所有可能。
//            2、递归构造出左右子树的所有合法 BST。
//        3、给root节点穷举所有左右子树的组合。
    //n 输出1到n的所以二叉树构造结果
    public List<TreeNode> generateTrees(int n) {
        if (n<=0){
            return new LinkedList<>();
        }
        return build(1,n);
    }

    public List<TreeNode> build(int lo,int hi){
        ////最外层res是所有整体结果,递归的是左右子树的res
        LinkedList<TreeNode> res = new LinkedList<>();
        if (lo>hi){
            res.add(null);
            return res;
        }
        ////1、穷举root节点的所有可能。i就是root节点
        for (int i = lo; i <= hi; i++) {
            //2、递归构造出左右子树的所有合法 BST。
            List<TreeNode> left = build(lo, i - 1);
            List<TreeNode> right = build(i+1, hi);
            //res+=left*right;组合一下
            for (TreeNode treeNodeLeft : left) {
                for (TreeNode treeNodeRight : right) {
                    TreeNode root = new TreeNode(i);
                    root.left=treeNodeLeft;
                    root.right=treeNodeRight;
                    res.add(root);
                }
            }
        }
        //最外层res是所有整体结果,递归的是左右子树的res
        return res;
    }


}

