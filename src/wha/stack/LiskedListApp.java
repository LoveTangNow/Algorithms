package wha.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wwha on 16-12-13.
 */
public class LiskedListApp {

    /**
     * 从尾部到首部打印链表的值
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
}
