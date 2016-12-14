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
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {

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
     *输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回
     */
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        int len = pre.length;
        if(len == 0) return null;


        TreeNode root = new TreeNode(pre[0]);//先序遍历的第一个为根节点
        //查找中序遍历中根节点的位置，以此划分左右子树
        int index = 0;
        for(int i=0; i<len; i++){
            if(in[i]==pre[0]) {
                index = i;
                break;
            }
        }

        int[] leftPre = new int[index],leftIn = new int[index];
        int[] rightPre = new int[len-index -1],rightIn = new int[len-index -1];
        //构造出左子树的先序遍历和中序遍历
        for(int i=0; i<len; i++){
            if(i<index){
                leftPre[i] = pre[i+1];
                leftIn[i] = in[i];
            }else if(i>index){
                rightPre[i-index-1] = pre[i];
                rightIn[i-index-1] = in[i];
            }


        }

        root.left = reConstructBinaryTree(leftPre,leftIn);
        root.right = reConstructBinaryTree(rightPre,rightIn);

        return root;
    }

    /**
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
     * 二叉搜索树：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉排序树。
     * KEY:最后一个值为根节点，去掉根节点剩下的序列为T，还剩两个子树；
     * 序列T最后一个值变为右子树的根节点，这个节点比在他同级的左树和自己的左子树的所有节点都大；
     * 比自己右子树的所有节点都小。（这就是可以递归的地方）;
     * 把所有树按照上面的方式递归，
     */
    public static boolean verifySquenceOfBST(int [] sequence) {
        int len = sequence.length;
        if(len == 0)    return false;
        int i = 0;
        while(--len > 0){
            while(sequence[i] < sequence[len])  i++;//左树及左子树
            while(sequence[i] > sequence[len])  i++;//右子树
            if(len>i)   return false;
            i=0;
        }

        return true;
    }
}
