package link;

import java.util.Objects;

public class FirstLastLinkListTest {
    public static void main(String[] args) {
        FirstLastLinkList<String> list = new FirstLastLinkList<>();

        list.insertFirst("Mary");
        list.insertLast("Ben");
        list.displayList();

        list.deleteFirst();
        list.insertLast("Jack");
        list.insertFirst("Lili");
        list.displayList();

        if(Objects.nonNull(list.findNode("Lili"))){
            System.out.println("Find Lili");
        }

        list.deleteNode("Lili");
        if(Objects.isNull(list.findNode("Lili"))){
            System.out.println("Not Find Lili");
        }

        list.displayList();
    }
}
