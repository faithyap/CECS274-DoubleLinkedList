public class DLQueueTester {
	
	public static void main(String[] args){
		
		DLQueue myQueue = new DLQueue();
		myQueue.add("This");
		myQueue.add("is");
		myQueue.add("my");
		myQueue.add("Queue");
		
		System.out.println(myQueue.peek());	System.out.println("Expected: This");
		myQueue.remove();
		System.out.println("\n" + myQueue.peek());	System.out.println("Expected: is");
		myQueue.remove();
		System.out.println("\n" + myQueue.peek());	System.out.println("Expected: my");
		myQueue.remove();
		System.out.println("\n" + myQueue.peek());	System.out.println("Expected: Queue");
		
		myQueue.remove();
		System.out.println("\n" + myQueue.peek());	// <<---------- THROWS NoSuchElementException Stack Message
	}
}
