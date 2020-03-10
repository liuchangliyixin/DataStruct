package link;

public class SingleLinkListTest {
    public static void main(String[] args) {
        SingleLinkList<Integer> intList = new SingleLinkList<>();
        intList.insertFirst(2);
        intList.insertFirst(8);
        intList.insertFirst(15);
        intList.insertFirst(5);
        intList.insertFirst(22);
        intList.insertFirst(9);
        intList.insertFirst(30);
        intList.displayList();

        System.out.println("删除第一个节点...");
        intList.deleteFirst();
        intList.displayList();

        System.out.println("删除指定节点...");
        intList.deleteNode(22);
        intList.displayList();
        intList.deleteNode(23);
        intList.displayList();

        System.out.println("查找指定节点...");
        if(intList.findNode(8)) {
            System.out.println("找到指定节点:8");
        }else{
            System.out.println("没找到指定节点:8");
        }
    }
}
