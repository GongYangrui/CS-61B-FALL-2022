package deque;

public class LinkedListDeque<T> {
    public static class Node<T> {
        public T item;
        public Node prev;
        public Node next;

        public Node(T i, Node prev, Node next) {
            item = i;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node<Integer> sentinel;

    public LinkedListDeque() {
        sentinel = new Node<>(27, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        size += 1;
        if (size == 1) {
            sentinel.next = new Node<>(item, sentinel, sentinel.next);
            sentinel.prev = sentinel.next;
        } else {
            Node p = new Node<>(item, sentinel, sentinel.next);
            sentinel.next.prev = p;
            sentinel.next = p;
        }
    }

    public void addLast(T item) {
        size += 1;
        if (size == 1) {
            sentinel.next = new Node<>(item, sentinel, sentinel.next);
            sentinel.prev = sentinel.next;
        } else {
            Node p = new Node<>(item, sentinel.prev, sentinel);
            sentinel.prev.next= p;
            sentinel.prev = p;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        if (size >= 0) {
            return size;
        }
        return 0;
    }

    public void printDeque() {
        Node p = sentinel.next;
        if (p.next != sentinel) {
            System.out.print(p.item);
        }
        System.out.println(p.item);
    }

    public T removeFirst() {
        size -= 1;
        if (size > 0) {
            T item = (T)sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return item;
        } else if (size == 0) {
            T item = (T)sentinel.next.item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            return item;
        }
        return null;
    }

    public T removeLast() {
        size -= 1;
        if (size > 0) {
            T item = (T)sentinel.prev.item;
            Node p = sentinel.prev.prev;
            p.next = sentinel;
            sentinel.prev = p;
            return item;
        } else if (size == 0) {
            T item = (T)sentinel.prev.item;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            return item;
        }
        return null;
    }

    public T get(int index) {
        Node p = sentinel;
        for (int i = -1; i < index; i += 1) {
            p = p.next;
        }
        return (T)p.item;
    }

    public boolean equals(Object o) {
        Node p = sentinel.next;
        return o instanceof Node && o.equals(p);
    }

    public T getRecursive(int index) {
        Node p = sentinel;
        for (int i = -1; i < index; i += 1) {
            p = p.next;
        }
        return (T)p.item;
    }
}
