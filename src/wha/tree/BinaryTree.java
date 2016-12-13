package wha.tree;

import java.util.*;

/**
 * Created by wwha on 16-12-13.
 */
public class BinaryTree {


    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
     * KEY: 借助一个队列
     */
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        ArrayList<Integer> vals = new ArrayList<>();
        if(root == null)    return vals;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){//队列不为空，取出队列的首元素，把左右子树加入队列中
            TreeNode treeNode = queue.poll();
            if(treeNode.left != null){
                queue.offer(treeNode.left);
            }

            if(treeNode.right != null){
                queue.offer(treeNode.right);
            }

            vals.add(treeNode.val);
        }

        return vals;
    }

    /**
     *获取二叉树的深度
     * KEY: 递归
     */
    public static int getTreeDepth(TreeNode root){
        int dep1,dep2;
        if(root == null){
            return 0;
        }
        dep1 = getTreeDepth(root.left);
        dep2 = getTreeDepth(root.right);
        return dep1 >= dep2 ? dep1+1 : dep2 + 1;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * 二叉搜索树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     */
    public static boolean verifySquenceOfBST(int [] sequence) {
        return true;
    }
}
