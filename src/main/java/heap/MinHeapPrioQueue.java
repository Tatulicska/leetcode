package heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class MinHeapPrioQueue {

	// Main driver method
	public static void main(String args[])
	{

	  // Creating empty priority queue
	  PriorityQueue<Integer> pQueue = new PriorityQueue<>();

	  // Adding items to the priority queue
	  // using add() method
	  pQueue.add(10);
	  pQueue.add(30);
	  pQueue.add(20);
	  pQueue.add(400);

	  // Printing the most priority element
	  System.out.println("Head value using peek function:" + pQueue.peek());

	  // Printing all elements
	  System.out.println("The queue elements:");

	  // Iterating over objects using Iterator
	  // so do creating an Iterator class

	  // Iterating toill there is single element left in
	  // object using next() method
	  for (Integer integer : pQueue) System.out.println(integer);

	  // Removing the top priority element (or head) and
	  // printing the modified pQueue using poll()
	  pQueue.poll();
	  System.out.println("After removing an element "
		  + "with poll function:");

	  // Again creating iterator object

	  for (Integer integer : pQueue) System.out.println(integer);

	  // Removing 30 using remove()
	  pQueue.remove(30);

	  System.out.println("after removing 30 with"
		  + " remove function:");

	  // Again creating iterator object
	  for (Integer integer : pQueue) System.out.println(integer);

	  // Check if an element is present using contains()
	  boolean b = pQueue.contains(20);
	  System.out.println("Priority queue contains 20 "
		  + "or not?: " + b);

	  Object[] arr = pQueue.toArray();

	  System.out.println("Value in array: ");

	  for (Object o : arr)
		System.out.println("Value: " + o.toString());
	}

}
