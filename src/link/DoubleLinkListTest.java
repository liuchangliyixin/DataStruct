package link;

import model.DoubleLinkNode;

public class DoubleLinkListTest {
    public static void main(String[] args) {
        DoubleLinkList<String> list = new DoubleLinkList<>();
        list.disPlay();

        list.insertFirst("Mary");
        list.insertFirst("Bob");
        list.disPlay();

        list.deleteLast();
        list.insertLast("Lili");
        list.disPlay("last");

        list.insertLast("Mike");
        list.deleteFirst();
        list.disPlay("last");

        list.insertLast("Jack");
        list.deleteNode("Lili");
        list.disPlay();
    }
}
