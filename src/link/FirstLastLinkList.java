package link;

import model.FirstLastLinkNode;

/**
 * 双端链表
 *  相对于单链表除了指向第一个节点的指针，多了一个指向最后一个节点的指针
 *  使得我们可以方便地访问最后一个节点，例如在最后一个节点之后插入数据
 *  但是删除操作还是需要遍历获得最后一个节点的前一个节点
 * @param <T>
 */
public class FirstLastLinkList<T> {

    private FirstLastLinkNode<T> first;
    private FirstLastLinkNode<T> last;

    public FirstLastLinkList(){
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){ return first == null; }

    public void insertFirst(T value){
        FirstLastLinkNode newNode = new FirstLastLinkNode(value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else{
            newNode.setNext(first);
            first = newNode;
        }
    }

    public void insertLast(T value){
        FirstLastLinkNode newNode =  new FirstLastLinkNode(value);
        if(isEmpty()){
            first = last = newNode;
        }else{
            last.setNext(newNode);
            last = newNode;
        }
    }

    public FirstLastLinkNode deleteFirst(){
        if(isEmpty()){
            System.out.println("No Node to Delete!");
            return null;
        }

        FirstLastLinkNode current = first;
        if(first == last){
            last = null;
        }
        first = first.getNext();
        return current;
    }

    public FirstLastLinkNode findNode(T index){
        if(isEmpty()){
            System.out.println("Empty List to Find Node!");
            return null;
        }

        FirstLastLinkNode current = first;
        while(current != null){
            if(index.equals(current.getVal())){
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    public FirstLastLinkNode deleteNode(T index){
        if(isEmpty()){
            System.out.println("Empty List to Delete Node!");
            return null;
        }

        FirstLastLinkNode current = first;
        FirstLastLinkNode parent = first;
        while(current != null){
            if(index.equals(current.getVal())){
                if (first == last){
                    first = last = null;
                    return current;
                }

                if(current == first){
                    first = first.getNext();
                }

                if(current == last){
                    last = parent;
                }

                parent.setNext(current.getNext());
                return current;
            }
            parent = current;
            current = current.getNext();
        }
        return null;
    }

    public void displayList(){
        if(isEmpty()){
            System.out.println("Empty List to Display!");
            return;
        }
        System.out.println("Display List --> ");
        FirstLastLinkNode current = first;
        while(current != null){
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}
