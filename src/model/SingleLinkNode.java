package model;

/**
 * 单链表节点类
 */
public class SingleLinkNode<T> {

    private T val;
    private SingleLinkNode next;

    public SingleLinkNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public SingleLinkNode getNext() {
        return next;
    }

    public void setNext(SingleLinkNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleLinkNode{" +
                "val=" + val +
                '}';
    }
}
