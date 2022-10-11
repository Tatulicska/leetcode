package queues;
//First in First Out (FIFO) order.
public class QueueNode {
	static Node top;

  public static void main(String[] args) {
	enqueue(4);
	enqueue(5);
	enqueue(2);
	enqueue(1);//1->2->5->4->
	dequeue();//1->2->5->
	System.out.println();
  }

  static public void dequeue() {
	Node current = top.next;
	Node prev = top;
	while (current.next != null) {
	  current = current.next;
	  prev = prev.next;
	}
	prev.next = null;
  }

  public static void enqueue(int data) {
	Node node = new Node(data);
	node.next = top;
	top = node;
  }

	private static class Node {
	int data;
	Node next;

	public Node(int data) {
	  this.data = data;
	}
  }
}
