package wha.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wwha on 16-12-13.
 */
public class LiskedListApp {


    /**
     *输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head = null || k<1)  return  null;

        List<ListNode> list = new ArrayList<ListNode>();
        while(head.next != null){
            list.add(head.next);
            head = head.next;
        }
        if(k>list.size())   return null;
        return list.get(list.size()-k);
    }

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
