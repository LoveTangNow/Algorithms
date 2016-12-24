package wha.stack;

import java.util.*;

/**
 * Created by wwha on 16-12-13.
 */
public class LiskedListApp {


    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;

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


    /**
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
     * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
     * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空
     */

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null)   return null;
        RandomListNode head = new RandomListNode(pHead.label);
        head.next = Clone(pHead.next);
        head.random = Clone(pHead.random);

        return head;
    }

    /**
     * 输入两个链表，找出它们的第一个公共结点。
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null || pHead2==null)	return null;
        Map<ListNode,String> map = new HashMap<>();
        ListNode  temp = pHead1;
        while(temp != null){
            map.put(temp,null);
            temp = temp.next;
        }
        temp = pHead2;
        while (temp != null){
            if(map.containsKey(temp)){
                return temp;
            }
        }

        return null;
    }

    /**
     *要是能长度一样就好办了,同步查找next
     * key:两个链表相加
     */
    public ListNode findFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int loop =0;// 等于2时说明已经相加循环了一遍,没有公共点,返回null
        while (p1 != p2){
            if(p1==null){
                p1 = pHead2;
                loop++;
            }else p1 = p1.next;
            if(loop>1){
                return null;
            }
            p2 = (p2==null ? pHead1 : p2.next);
        }

        return p1;
    }
}
