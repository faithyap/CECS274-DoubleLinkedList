/**
 * This program represents a doubly-linked list and can be navigated through
 * methods that add, remove, replace, and peek the elements within the list.
 * 
 * @author  Faith Yap
 * @version 1.0
 * @since   11/16/2015
 */

import java.util.NoSuchElementException;
public class DLinkedList
{
    private Node first;
    private Node last;
    
    /**
     * Constructor method to initialize the instance variables
     */
    public DLinkedList()
    {
        first = null;
        last = null;
    }
    
    /**
     * Retrieves the first object in the list
     * @return object that is first in the list
     */
    public Object getFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        return first.data;
    }
    
    /**
     * Retrieves the last object in the list
     * @return object that is last in the list
     */
    public Object getLast()
    {
        if (last == null)
        {
            throw new NoSuchElementException();
        }
        return last.data;
    }
  
    /**
     * Removes the object at the beginning of the list
     * @return the object that was removed
     */
    public Object removeFirst()
    {
        if (first == null)
        {
            throw new NoSuchElementException();
        }
        Object element = first.data;
        first = first.next;
        return element;
    }
  
    /**
     * Adds an object to the beginning of the list
     * @param element object to be added in the beginning of the list
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;
        newNode.previous = null;
        first = newNode;
    }
    
    /**
     * Removes the object at the end of the list
     * @return the object that was removed
     */
    public Object removeLast()
    {
        if (last == null)
        {
            throw new NoSuchElementException();
        }
        Object element = last.data;
        last = last.previous;
        return element;
    }
    
    /**
     * Adds an object to the end of the list
     * @param element object to be added to the end of the list
     */
    public void addLast(Object element)
    {
        Node newNode = new Node();
        newNode.next = null;
        newNode.data = element;
        newNode.previous = last;
        
        if (last == null)
        {
            last = newNode;
        }
        else
        {
            last.next = newNode;
            last = newNode;
        }
        
        if (first == null)
        {
            first = newNode;
        }
    }
  
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }
  
    /**
     * Creates an object called Node
     */
    class Node
    {
        public Object data;
        public Node next;
        public Node previous;
    }
  
    /**
     * Creates an object called LinkedListIterator
     */
    class LinkedListIterator implements ListIterator
    {
        private Node position;
        private Node previous;
        private boolean isAfterNext;
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false;
        }
        /**
         * Moves the ListIterator to the next position
         * @return the data that the element of that position holds
         */
        public Object next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            previous = position;
            isAfterNext = true;
            if (position == null)
            {
                position = first;
            }
            else 
            {
                position = position.next;
            }
            return position.data;
        }
    
        /**
         * Checks whether the list has more elements after the current position
         * @return boolean statement that determines whether the list continues
         */
        public boolean hasNext()
        {
            if (position == null)
            {
                return first != null;
            }
            else 
            {
                return position.next != null;
            }
        }
        
        /**
         * Adds an element where the ListIterator is positioned
         * @param element object to be added
         */
        public void add(Object element)
        {
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            isAfterNext = false;
        }
        
        /**
         * Removes an element where the ListIterator is positioned
         * @return object that was removed
         */
        public Object remove()
        {
            if (!isAfterNext)
            {
                throw new NoSuchElementException();
            }
            if (position == first)
            {
                Object removed = removeFirst();
                return removed;
            }
            else
            {
                previous.next = position.next;
                Object removed = position.data;
                return removed;
            }
        }
        
        /**
         * Replaces the object where the ListIterator with another object
         * @param element object to replace the previous one
         */
        public void set(Object element)
        { 
            if (!isAfterNext)
            {
                throw new NoSuchElementException();
            }
            position.data = element;
        }
    }   
}