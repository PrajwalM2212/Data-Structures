package OOP_ADT;

public interface Bag {

    boolean add(Object item);

    boolean contains(Object item);

    Object[] toArray();

    int numItems();

    Object grab();

    boolean remove(Object item);
}