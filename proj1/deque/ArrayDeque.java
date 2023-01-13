package deque;

import edu.princeton.cs.algs4.StdRandom;

public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private int capacity;

    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        nextFirst = StdRandom.uniform(0, capacity);
        if (nextFirst == capacity - 1) {
            nextLast = 0;
        } else {
            nextLast = nextFirst + 1;
        }
        size = 0;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resize(capacity, nextFirst, nextLast);
        }
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = capacity - 1;
        } else {
            nextFirst -= 1;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resize(capacity, nextFirst, nextLast);
        }
        items[nextLast] = item;
        if (nextLast == capacity - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
        size += 1;
    }

    private void resize(int capacity, int nextFirst, int nextLast) {
        T[] p = (T[]) new Object[capacity * 2];
        int forth = nextFirst + 1;
        int back = nextLast - 1;
        if (back > forth) {
            System.arraycopy(items, 0, p, (capacity * 2) / 4, capacity);
            this.nextFirst = (capacity * 2) / 4 - 1;
            this.nextLast = (capacity * 2) / 4 * 3;
        } else {
            System.arraycopy(items, 0, p, 0, back + 1);
            System.arraycopy(items, forth, p, 2 * capacity - (capacity - forth), capacity - forth);
            this.nextFirst = 2 * capacity - (capacity - forth) - 1;
        }
        items = p;
        this.capacity = capacity * 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < capacity; i += 1) {
            if (items[i] != null) {
                System.out.print(items[i]);
                System.out.print(" ");
            }
        }
        System.out.print("\n");
    }

    public T removeFirst() {
        T p;
        if (nextFirst == capacity - 1) {
            p = items[0];
            items[0] = null;
            nextFirst = 0;
        } else {
            p = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst += 1;
        }
        size -= 1;
        if (size < capacity / 4 && size > 2) {
            remove(capacity);
        }
        return p;
    }

    public T removeLast() {
        T p;
        if (nextLast == 0) {
            p = items[capacity - 1];
            items[capacity - 1] = null;
            nextLast = capacity - 1;
        } else {
            p = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast -= 1;
        }
        size -= 1;
        if (size < capacity / 4 && size > 2) {
            remove(capacity);
        }
        return p;
    }

    private void remove(int capacity) {
        T[] p = (T[]) new Object[capacity / 2];
        int j = 0;
        for (int i = 0; i < capacity; i += 1) {
            if (items[i] != null) {
                p[j] = items[i];
                j += 1;
            }
        }
        items = p;
        this.capacity = capacity / 2;
        this.nextFirst = capacity / 2 - 1;
        this.nextLast = this.size;
    }

    public T get(int index) {
        return items[index];
    }

    public boolean equals(Object o) {
        int i;
        for (i = 0; i < capacity; i += 1) {
            if (items[i] != null) {
                break;
            }
        }
        T p = items[i];
        return o instanceof ArrayDeque && o.equals(p);
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        for (int i = 0; i < 9; i += 1) {
            L.addLast(i);
        }
        L.printDeque();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        System.out.println(L.size());
    }

}
