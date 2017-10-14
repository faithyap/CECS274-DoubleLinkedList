public class LinkedListDemo{
	public static void main(String args[]){
		
		// Creating the linked list
		DLinkedList list = new DLinkedList();
		list.addLast(9);  list.addFirst("I");  list.addFirst(5);  list.addFirst("E");  
		list.addFirst(1);  list.addFirst("A");  list.addFirst(4);  list.addFirst("D");  
		list.addFirst(1);  list.addFirst("A");  list.addFirst(3);  list.addFirst("C");
		list.addLast("Whip it into shape!");
		
		// Printing list
		ListIterator iter = list.listIterator();
		while(iter.hasNext()){
			System.out.print(iter.next() + " ");
		}
		System.out.println("\nExpected: C 3 A 1 D 4 A 1 E 5 I 9 Whip it into shape! \n");
		
		
		// Modifying list
		Object unwantedFirst = list.removeFirst();		
		Object unwantedLast = list.removeLast(); 
		Object unwanted;
		
		iter = list.listIterator();
		iter.next();	iter.add("*");
		iter.next();    unwanted = iter.remove();
		
		
		int index = 1;
		
		while(iter.hasNext()){
			iter.next();
			if(index%2 == 0){
				iter.remove();
			}
			index++;	
		}
		
		// Printing Modified List
		iter = list.listIterator();
		while(iter.hasNext()){
			System.out.print( iter.next() + " ");
		}
		System.out.println("\nExpected: 3 * 1 4 1 5 9 ");
		
		// Printing some deleted items
		System.out.println("\n" + unwantedFirst);  	System.out.println("Expected: C");
		System.out.println("\n" + unwantedLast);  	System.out.println("Expected: Whip it into shape!");
		System.out.println("\n" + unwanted);		System.out.println("Expected: A");
		
		// Getting first and last items
		System.out.println("\n" + list.getFirst());		System.out.println("Expected: 3");
		System.out.println("\n" + list.getLast());		System.out.println("Expected: 9");
		
		// Setting some elements
		iter = list.listIterator();
		iter.next(); iter.next();
		iter.set(".");
		
		// Printing Modified List
                System.out.println("");
		iter = list.listIterator();
		while(iter.hasNext()){
			System.out.print( iter.next() + " ");
		}
		System.out.println("\nExpected: 3 . 1 4 1 5 9 ");
		
	}
}
