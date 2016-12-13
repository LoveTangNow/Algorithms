package wha.stack;

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

    public static void main(String[] args){
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,5,3,1,2};
        boolean b = IsPopOrder(push, pop2);
        System.out.println(b);
    }
}
