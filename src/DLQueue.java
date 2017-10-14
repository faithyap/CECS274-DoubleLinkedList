/**
 * This programs imitates the functions of a Queue through the implementation
 * of a doubly-linked list, allowing it to add, remove and peek the elements
 * inside the list.
 * 
 * @author  Faith Yap
 * @version 1.0
 * @since   11/16/2015
 */

import java.util.NoSuchElementException;
public class DLQueue
{
    public static DLinkedList queue = new DLinkedList();
    /**
     * Adds an element to the end of the list, just like a Queue
     * @param element object to be added to the end of the list
     */
    public void add(Object element)
    {
        queue.addLast(element);
    }
    
    /**
     * Removes an element from the beginning of the list, just like a Queue
     * @return object that was removed from the beginning of the list
     */
    public Object remove()
    {
        return queue.removeFirst();
    }
    
    /**
     * Retrieves the object in the beginning of the list, imitating the peek function of a queue
     * @return object in the beginning of the list
     */
    public Object peek()
    {
        try
        {
            queue.getFirst();
        }
        catch(Throwable e)
        {
            e.printStackTrace();
        }
        return queue.getFirst();
    }
}