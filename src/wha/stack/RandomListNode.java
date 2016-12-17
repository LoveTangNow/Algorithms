package wha.stack;

/**
 * Created by wwha on 16-12-16.
 * 每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点
 */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}