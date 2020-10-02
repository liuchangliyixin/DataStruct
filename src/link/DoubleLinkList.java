package link;

import model.DoubleLinkNode;

/**
 *双向链表
 *这里加入了双端的特性，也就是有一个指向最后一个节点的引用
 *双向链表的节点在单链表节点的基础上加入了指向前一个节点的引用
 *遍历：双向链表既可以向前也可以向后遍历
 *插入：既可以在第一个节点插入，也可以在最后一个节点插入，也可以遍历插入某一节点之后
 *删除：同上
 * @param <T>
 */
public class DoubleLinkList<T> {

    private DoubleLinkNode<T> first;
    private DoubleLinkNode<T> last;

    public DoubleLinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){ return first==null; }

    public void insertFirst(T value){
        DoubleLinkNode newNode = new DoubleLinkNode(value);
        if(isEmpty()){
            last = newNode;
        }else{
            first.setPrev(newNode);
        }
        newNode.setNext(first);
        first = newNode;
    }

    public void insertLast(T value){
        DoubleLinkNode newNode = new DoubleLinkNode(value);
        if(isEmpty()){
            first = newNode;
        }else{
            last.setNext(newNode);
        }
        newNode.setPrev(last);
        last = newNode;
    }

    public DoubleLinkNode deleteFirst(){
        if(isEmpty()){
            System.out.println("Empty List to Delete!");
            return null;
        }

        DoubleLinkNode temp = first;
        if(first.getNext() == null){
            last = null;
        }else{
            first.getNext().setPrev(null);
        }
        first = first.getNext();
        return temp;
    }

    public DoubleLinkNode deleteLast(){
        if(isEmpty()){
            System.out.println("Empty List to Delete!");
            return null;
        }

        DoubleLinkNode temp = last;
        if(last.getPrev() == null){
            first = null;
        }else{
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        return temp;
    }

    public boolean findNode(T index){
        if(isEmpty()){
            System.out.println("Empty List to Find!");
            return false;
        }

        DoubleLinkNode current = first;
        while(current != null){
            if(index.equals(current.getVal())){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean insertAfter(T key,T value){
        if(isEmpty()){
            System.out.println("Empty List! Can not insert!");
            return false;
        }
        DoubleLinkNode<T> newNode = new DoubleLinkNode<T>(value);
        DoubleLinkNode<T> current = first;
        while(!current.getVal().equals(key)){
            current = current.getNext();
            if(current == null){
                System.out.println("Can not find key!");
                return false;
            }
        }
        if(current == last){
            newNode.setNext(null);
            last = newNode;
        }else{
            newNode.setNext(current.getNext());
            current.getNext().setPrev(newNode);
        }
        newNode.setPrev(current);
        current.setNext(newNode);
        return true;
    }


    public DoubleLinkNode deleteNode(T index){
        if(isEmpty()){
            System.out.println("Empty List to Delete!");
            return null;
        }

        DoubleLinkNode current = first;
        while(current != null){
            if(index.equals(current.getVal())){
                if(current == first){
                    first = current.getNext();
                }else{
                    current.getPrev().setNext(current.getNext());
                }
                if(current == last){
                    last = current.getPrev();
                }else {
                    current.getNext().setPrev(current.getPrev());
                }
            }
            current = current.getNext();
        }
        return null;
    }

    public void disPlay(){
        disPlay("prev");
    }

    public void disPlay(String mode){
        if(isEmpty()){
            System.out.println("Empty List to Display!");
            return;
        }
        System.out.println("Display List Member:------>");
        DoubleLinkNode current = null;
        if("last".equals(mode)){
            current = last;
            while(current != null){
                System.out.println(current.toString());
                current = current.getPrev();
            }
        }else{
            current = first;
            while(current != null){
                System.out.println(current.toString());
                current = current.getNext();
            }

        }
    }
}
