package LinkedLists;

public class LinkedList<T> {

    private class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;

    public void append(T data) {

        if (head == null) {
            head = new Node<>(data);
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = new Node<>(data);

    }

    public void prepend(T data) {

        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;

    }

    public void deleteByValue(T data) {

        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {

            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }

    }


    public static void main(String[] args) {

    }

}
