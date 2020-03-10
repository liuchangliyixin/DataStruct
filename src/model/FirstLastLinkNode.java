package model;

/**
 * 双端链表节点类
 * @param <T>
 */
public class FirstLastLinkNode<T> {
    private T val;
    private FirstLastLinkNode<T> next;

    public FirstLastLinkNode(T val) {
        this.val = val;
    }

    public FirstLastLinkNode getNext() {
        return next;
    }

    public void setNext(FirstLastLinkNode next) {
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "FirstLastLinkNode{" +
                "val=" + val +
                '}';
    }
}
