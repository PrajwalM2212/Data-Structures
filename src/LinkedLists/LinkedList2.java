package LinkedLists;

public class LinkedList2<T> {

    private class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;

    // Stack archi
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

    // Queue archi
    public void prepend(T data) {

        Node<T> newHead = new Node<>(data);
        newHead.next = head;
        head = newHead;

    }

    public T valueAtIndex(int pos) {

        Node<T> current = head;
        while (pos > 0) {
            current = current.next;
            pos--;
        }

        return current.data;

    }

    public void deleteByValue(T data) {

        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
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


    public int size() {

        int count = 0;

        if (head == null) {
            return 0;
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        return count + 1;

    }


    public static void main(String[] args){

    }

}
