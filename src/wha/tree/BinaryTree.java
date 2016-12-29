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
        if (root == null) return vals;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {//队列不为空，取出队列的首元素，把左右子树加入队列中
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }

            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }

            vals.add(treeNode.val);
        }

        return vals;
    }



    /**
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
     * 则重建二叉树并返回
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        int len = pre.length;
        if (len == 0) return null;


        TreeNode root = new TreeNode(pre[0]);//先序遍历的第一个为根节点
        //查找中序遍历中根节点的位置，以此划分左右子树
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (in[i] == pre[0]) {
                index = i;
                break;
            }
        }

        int[] leftPre = new int[index], leftIn = new int[index];
        int[] rightPre = new int[len - index - 1], rightIn = new int[len - index - 1];
        //构造出左子树的先序遍历和中序遍历
        for (int i = 0; i < len; i++) {
            if (i < index) {
                leftPre[i] = pre[i + 1];
                leftIn[i] = in[i];
            } else if (i > index) {
                rightPre[i - index - 1] = pre[i];
                rightIn[i - index - 1] = in[i];
            }


        }

        root.left = reConstructBinaryTree(leftPre, leftIn);
        root.right = reConstructBinaryTree(rightPre, rightIn);

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
    public static boolean verifySquenceOfBST(int[] sequence) {
        int len = sequence.length;
        if (len == 0) return false;
        int i = 0;
        while (--len > 0) {
            while (sequence[i] < sequence[len]) i++;//左树及左子树
            while (sequence[i] > sequence[len]) i++;//右子树
            if (len > i) return false;
            i = 0;
        }

        return true;
    }

    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     */
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;

        if (root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) && isSubtree(root2.right, root2.right);
        } else return false;
    }


    /**
     * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
     */

    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> li = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) return list;
        li.add(root.val);
        target -= root.val;//每经过一层的节点，减去节点的值，到达叶子节点时，看是不是减为0；
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(li));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        li.remove(li.size() - 1);// 每探索完一个节点,都在路径列表li中移除，不干扰下条路径的形成
        return list;
    }


    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
     * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * KEY: 中序遍历 非递归
     */
    public TreeNode Convert(TreeNode root) {
        if (root == null) return null;
        TreeNode curr = root;
        TreeNode pre = null;
        boolean isFirst = true;
        Stack<TreeNode> stack = new Stack<>();//存储中序遍历的节点

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            if (isFirst) {//设置首节点
                root = curr;
                pre = root;
                isFirst = false;
            } else {
                pre.right = curr;
                curr.left = pre;
                pre = curr;
            }

            curr = curr.right;
        }

        return root;
    }
    /**
     * 获取二叉树的深度
     * KEY: 递归
     */
    public static int getTreeDepth(TreeNode root) {
        int dep1, dep2;
        if (root == null) {
            return 0;
        }
        dep1 = getTreeDepth(root.left);
        dep2 = getTreeDepth(root.right);
        return dep1 >= dep2 ? dep1 + 1 : dep2 + 1;
    }

    /**
     * 平衡二叉树:它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，
     * 并且左右两个子树都是一棵平衡二叉树
     */
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        getTreeDepthTemp(root);
        return isBalanced;

    }
    public int getTreeDepthTemp(TreeNode root) {
        int dep1, dep2;
        if (root == null) {
            return 0;
        }
        dep1 = getTreeDepth(root.left);
        dep2 = getTreeDepth(root.right);
        if(Math.abs(dep1-dep2)>1){
            isBalanced = false;
        }

        return dep1 >= dep2 ? dep1 + 1 : dep2 + 1;
    }

    /**
     *给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * key:先找到根节点,再中序遍历找到目标节点,下一次循环弹栈的元素就是要求的值.
     */
    public TreeLinkNode getNext(TreeLinkNode pNode) {

        TreeLinkNode p,curr = pNode;
        Stack<TreeLinkNode> stack = new Stack<>();
        boolean isGet = false;
        while(curr.next != null){
            curr = curr.next;
        }

        while(curr!=null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            p = stack.pop();
            if(isGet)   return p;
            if(p == pNode){
                isGet = true;
            }
            curr = p.right;
        }
        return null;
    }
}
