package link;

import model.SingleLinkNode;

/**
 *单链表类
 *单链表需要有一个前驱节点first-->指向链表的第一个节点，初始化为null
 *单链表需要实现的操作
 *  在表头插入和删除节点
 *  查找指定节点
 *  删除指定节点
 */
public class SingleLinkList<T> {
    private SingleLinkNode<T> first;

    public SingleLinkList() {
        //这个并不是必须的，引用类型在创建之初会自动赋值为null，这里只是一个态度，表明first一开始是null
        this.first = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(T value){
        SingleLinkNode<T> newNode = new SingleLinkNode<>(value);
        if(isEmpty()){
            first = newNode;
        }else{
            newNode.setNext(first);
            first = newNode;
        }
    }

    public SingleLinkNode deleteFirst(){
        if(isEmpty()){
            System.out.println("Empty List To Delete!");
            return null;
        }
        SingleLinkNode temp = first;
        first = first.getNext();
        return temp;
    }

    public boolean findNode(T index){
        if(isEmpty()){
            System.out.println("Empty List To Find!");
            return false;
        }
        SingleLinkNode current = first;
        while(current != null){
            if(index.equals(current.getVal())){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public SingleLinkNode deleteNode(T index){
        if(isEmpty()){
            System.out.println("Empty List To Delete!");
            return null;
        }
        SingleLinkNode current = first;
        SingleLinkNode parent = first;
        while(current != null){
            if(index.equals(current.getVal())){
                //这里需要考虑当前节点是不是第一个节点
                if(current == first){
                    first = first.getNext();
                }else{
                    parent.setNext(current.getNext());
                }
                return current;
            }
            parent = current;
            current = current.getNext();
        }
        return null;
    }

    public void displayList(){
        if(isEmpty()){
            System.out.println("Empty List To Display!");
            return;
        }
        System.out.println("SingleList Display:");
        SingleLinkNode current = first;
        while(current != null){
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}
