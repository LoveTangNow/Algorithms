package wha.stack;

import edu.princeton.cs.algs4.In;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wwha on 16-12-13.
 */
public class StackApp {
    /**
     *
     *输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        for(int i=0, j=0; i< pushA.length;i++){
            stack.push(pushA[i]);//入栈
            while(j<popA.length && popA[j]==stack.peek()){//每一次入站之后都检查出栈的可能性
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }

    /**
     *输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
     * 运行超时
     */
    public static int numberOf1_my(int n) {
        if(n==0) return 0;
        int count = 0;
        if(n>0){
            while(n!=0){
                if(n%2 == 1)    count++;
                n /=2;
            }
        }else{
            n = -n;
            while(n%2 != 1){
                n /= 2;
            }
            count++;n /= 2;
            while (n!=0){
                if(((n%2) ^ 1) ==1)  count++;
                n /= 2;
            }
            count++;
        }

        return count;
    }

    public static int numberOf1(int n) {
        int count = 0;
        while(n!=0){
            count++;
            n = (n-1)& n;
        }
        return count;
    }

    @Test
    public void isPopOrderTest(){
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,5,3,1,2};
        boolean b = IsPopOrder(push, pop2);
        System.out.println(b);
    }

    @Test
    public void numberOf1Test() {
        System.out.println(numberOf1(-17));
    }

}
