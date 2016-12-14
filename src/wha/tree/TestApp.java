package wha.tree;

import org.junit.Test;

/**
 * Created by wwha on 16-12-13.
 */
public class TestApp {

    TreeNode root = new TreeNode(1);
    public TestApp() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5= new TreeNode(1);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(1);
        root.left  = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n3.left = n6;
        n3.right = n7;
        n6.left = n8;
    }
    @Test
    public void getDepth(){
        System.out.println(BinaryTree.getTreeDepth(root));
    }


    @Test
    public  void reConstuct(){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = BinaryTree.reConstructBinaryTree(pre,in);
    }
}
