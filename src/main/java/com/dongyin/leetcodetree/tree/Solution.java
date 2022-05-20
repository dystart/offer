package com.dongyin.leetcodetree.tree;

import java.util.LinkedList;
import java.util.List;

/**序列化篇
 * @author dystart
 * @create 2022-04-09 23:21
 */
public class Solution {


}
//前序
class Codec {

    // 把一棵二叉树序列化成字符串
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root,sb);
        return sb.toString();
    }


    //StringBuilder 可以用于高效拼接字符串
    String NULL="#";
    String SPE=",";
    void traverse(TreeNode root,StringBuilder sb){
        if (root==null){
            sb.append(NULL).append(SPE);
            return;
        }
        sb.append(root.val).append(SPE);
        traverse(root.left,sb);
        traverse(root.right,sb);
    }


    // 把字符串反序列化成二叉树
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        return deSraverse(split,0);
    }


    public TreeNode deSraverse(String[] strings,int i){
        while (i<strings.length){
            if (strings[i]=="#"){
                return null;
            }else {
                TreeNode treeNode = new TreeNode(strings[i]);
                treeNode.left = deSraverse(strings, i + 1);
                treeNode.right = deSraverse(strings, i + 1);
                return treeNode;
            }
        }
        return null;

    }


}
