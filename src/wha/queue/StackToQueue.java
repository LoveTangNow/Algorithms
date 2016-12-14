package wha.queue;

import java.util.Stack;

/**
 * Created by wwha on 16-12-14.
 * 使用两个栈实现一个队列：
 * 栈1入栈，
 * 出栈时：栈1的元素全部出栈，入栈到栈2，栈2再出栈
 * key： 必须满足栈2为空时，才能栈1先出栈到栈2，栈2再出栈
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }

        if(stack2.empty()){
            while (!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }

        return  stack2.pop();
    }
}
