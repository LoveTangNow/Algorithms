package wha.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by wwha on 16-12-13.
 */
public class LiskedListApp {


    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head = null || k < 1) return null;

        List<ListNode> list = new ArrayList<ListNode>();
        while (head.next != null) {
            list.add(head.next);
            head = head.next;
        }
        if (k > list.size()) return null;
        return list.get(list.size() - k);
    }

    /**
     * 链表的反转
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;//把正向链表的下一个节点保存next
            head.next = pre; //把正向链表（当前节点）的下一个节点指向自己，实现反转
            pre = head;//把当前节点保存在pre中，最后的起始节点就是pre
            head = next;//下一个节点
        }

        return pre;
    }

    /**
     * 从尾部到首部打印链表的值
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     */

    public ListNode merge(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode mergeHead = null;
        ListNode current = null;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                if(mergeHead == null){
                    mergeHead = current = list1;
                }else{
                    current.next = list1;
                    current = current.next;
                }
                list1 = list1.next;
            }else{
                if(mergeHead == null){
                    mergeHead = current = list2;
                }else{
                    current.next = list2;
                    current = current.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null){
            current.next = list2;
        }else{
            current.next = list1;
        }
        return mergeHead;
    }

}