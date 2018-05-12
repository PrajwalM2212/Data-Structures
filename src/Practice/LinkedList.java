package Practice;

public class LinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    Node<T> head;

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
        Node<T> newHead = new Node<>(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteByValue(T data) {

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        if (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
        }

    }
}
