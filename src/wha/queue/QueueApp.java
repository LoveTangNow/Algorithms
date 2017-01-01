package wha.queue;

import jdk.internal.org.objectweb.asm.tree.InnerClassNode;
import wha.tree.TreeNode;

import java.util.*;

/**
 * Created by wwha on 17-1-1.
 */
public class QueueApp {

    /**
     *请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推。
     */
    public ArrayList<ArrayList<Integer>> printZ(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null)   return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.addFirst(null);//队首添加分隔符
        queue.push(pRoot);
        boolean leftToRight = true;
        while (queue.size() != 1){
            TreeNode temp = queue.poll();
            if(temp == null){
                Iterator<TreeNode> inter;
                if(leftToRight){
                    inter = queue.iterator();
                }else {
                    inter = queue.descendingIterator();
                }
                while (inter.hasNext()){
                    TreeNode node = (TreeNode)inter.next();
                    list.add(node.val);
                }
                res.add(new ArrayList<Integer>(list));
                list.clear();
                queue.push(null);
                leftToRight = !leftToRight;
                continue;
            }

            if( temp.left != null) {
                queue.push(temp.left);
            }
            if( temp.right != null) {
                queue.push(temp.right);
            }

        }
        return res;
    }

    ArrayList<ArrayList<Integer> > printL2R(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot == null)	return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(pRoot);

        ArrayList<Integer> li = new ArrayList<>();
        while(queue.size() != 1){
            TreeNode temp = queue.poll();
            if(temp == null){
                Iterator<TreeNode> inter = queue.iterator();
                while(inter.hasNext()){
                    li.add(((TreeNode)inter.next()).val);
                }

                list.add(new ArrayList<>(li));
                li.clear();
                queue.add(null);
                continue;
            }

            if(temp.left != null) {
                queue.add(temp.left);
            }

            if(temp.right != null){
                queue.add(temp.right);
            }

        }

        return list;
    }
}
