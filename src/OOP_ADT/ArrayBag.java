package OOP_ADT;

import java.util.Random;

public class ArrayBag implements Bag {


    private Object[] items;
    private int numItems;
    private static final int DEFAULT_MAX_SIZE = 50;

    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }

    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException();
        }

        this.items = new Object[maxSize];
        this.numItems = 0;
    }

    @Override
    public boolean add(Object item) {

        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (this.numItems == this.items.length) {
            return false;
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }

    }

    @Override
    public boolean contains(Object item) {

        boolean contains = false;

        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (this.items.length == 0 || this.numItems == 0) {
            contains = false;
        } else {

            for (Object object : this.items) {
                if (object != null) {
                    if (object.equals(item)) {
                        contains = true;
                    }
                }
            }
        }
        return contains;
    }

    @Override
    public Object[] toArray() {
        return this.items;
    }

    @Override
    public int numItems() {
        return this.numItems;
    }

    @Override
    public Object grab() {
        Random random = new Random();
        if (this.items.length == 0 || numItems == 0) {
            return null;
        }

        return this.items[random.nextInt(this.numItems)];

    }

    @Override
    public boolean remove(Object item) {

        boolean removed = true;
        if (item == null) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.numItems - i - 1);
                this.items[this.numItems - 1] = null;
                this.numItems = this.numItems - 1;
                removed = true;
                break;
            }
            removed = false;
        }
        return removed;
    }

    public static void main(String[] args) {

        ArrayBag arrayBag = new ArrayBag(4);
        arrayBag.add(4);
        arrayBag.add("Hello");
        arrayBag.add(56);
        arrayBag.remove(56);
        Object[] arr = arrayBag.toArray();

        for (Object obj : arr) {
            System.out.println(obj);
        }

    }
}
