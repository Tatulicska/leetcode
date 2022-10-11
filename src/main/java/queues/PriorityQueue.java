package queues;
//A priority queue is a special queue where:
//
//	1. Every item in the queue has a priority, and
//	2. Higher-priority items are dequeued before lower-priority items.
//	Picture a big list of bugs for an engineering team to tackle. You want to keep the highest-priority bugs at the top of the list.

//Binary Heap Priority Queue
//
//	This is the most common implementation but not the only one.
//
//	Worst Case
//	space	O(n)
//	peek	O(1)
//	dequeue	O(log(n))
//	enqueue	O(log(n))

//Other Options
//	A Sorted Array
//	To enqueue, use binary search to figure out where the new item should go. Then scoot items over to make space for the new item.
//	O(n) time, since in the worst case you have to scoot everything over to make room
//	To peek at the highest priority item, look at the item at index zero. (O(1)O(1) time)
//	To dequeue, scoot every item forward one index. (O(n)O(n) time)

//A Sorted Linked List
//	To enqueue, walk through the linked list to figure out where the new item should go. Then, reassign pointers to add the new item. (O(n) time)
//	To peek at the highest priority item, look at the item at the head of the linked list. (O(1)O(1) time)
//	To dequeue, update the linked list's head pointer to point to the second item.
//	(And deallocate the old head node, if you're using a language with manual memory management.) (O(1) time)


//Strengths:
//	Quickly access the highest-priority item. Priority queues allow you to peek at the top item in O(1)
//	while keeping other operations relatively cheap O(lg(n)).
//
//Weaknesses:
//	Slow enqueues and dequeues. Both operations take O(lg(n)) time with priority queues.
//	With normal first-in, first-out queues, these operations are O(1) time.

//Uses
//	Any time you want to handle things with different priority levels: triaging patients in a hospital,
//	locating the closest available taxi, or just a to-do list.
//	Operating system schedulers may use priority queues to select the next process to run,
//	ensuring high-priority tasks run before low-priority ones.
//	Certain foundational algorithms rely on priority queues:
//	Dijkstra's shortest-path
//	A* search (a graph traversal algorithm like BFS)
//	Huffman codes (an encoding for data compression)

public class PriorityQueue {

  private int frontIndex;

  private int backIndex;

  private final int capacity;

  private final int[] arr;

  public PriorityQueue(int capacity) {
	this.capacity = capacity;
	arr = new int[capacity];
	frontIndex = -1;
	backIndex = -1;
  }

  public static void main(String[] args) {

  }
}
