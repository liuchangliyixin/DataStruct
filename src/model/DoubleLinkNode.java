package model;

/**
 * 双向链表节点类
 *  拥有指向前一个节点和后一个节点的引用
 * @param <T>
 */
public class DoubleLinkNode<T> {
    private T val;
    private DoubleLinkNode<T> prev;
    private DoubleLinkNode<T> next;

    public DoubleLinkNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public DoubleLinkNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkNode<T> prev) {
        this.prev = prev;
    }

    public DoubleLinkNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleLinkNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "DoubleLinkNode{" +
                "val=" + val +
                '}';
    }
}
