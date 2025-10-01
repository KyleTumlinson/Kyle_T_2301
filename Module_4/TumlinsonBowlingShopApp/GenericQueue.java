package Module_4.TumlinsonBowlingShopApp;

import java.util.LinkedList;

public class GenericQueue<T> {
    // a generic linkedList for products
    private LinkedList<T> list = new LinkedList<>();

    // enqueue takes in a generic item to add to the list
    public void enqueue(T item)
    {
        list.addFirst(item);
    }
    // dequeue takes in nothing but returns the item it removes from the list
    public T deQueue()
    {
        return list.removeFirst();
    }
    // return the size of the list
    public int size()
    {
        return this.list.size();
    }
}
