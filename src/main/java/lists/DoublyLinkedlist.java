package lists;

public class DoublyLinkedlist {

  public static void main(String[] args) {
	new DoublyLinkedlist().create();

  }

  private void create() {
	DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
	doublyLinkedList.addAtHead(2);
	doublyLinkedList.addAtTail(3);
	doublyLinkedList.addAtTail(4);
	doublyLinkedList.addAtTail(10);

	doublyLinkedList.insertInSortedValue(1);
	doublyLinkedList.insertInSortedValue(2);
	doublyLinkedList.insertInSortedValue(11);
	doublyLinkedList.insertInSortedValue(-1);
	DoublyLinkedList.Node value = doublyLinkedList.findValue(10);
	doublyLinkedList.print();

  }


  static class DoublyLinkedList {
	Node head;

	public void addAtTail(int n) {
	  if (head == null) {
		head = new Node(n);
		return;
	  }

	  Node current = head;
	  while (current.next != null) {
		current = current.next;
	  }
	  current.next = new Node(n);
	  current.next.prev = current;
	}

	public void addAtHead(int n) {
	  if (head == null) {
		head = new Node(n);
		return;
	  }
	  Node current = new Node(n);
	  current.next = head;
	  head.prev = current;
	  head = current;


	}

	public void reverse() {
	  if (head == null) {
		return;
	  }
	  Node temp = head;
	  Node newHead = head;
	  while (temp != null) {
		Node prev = temp.prev;
		temp.prev = temp.next;
		temp.next = prev;
		newHead = temp;
		temp = temp.prev;
	  }
	  head = newHead;
	}

	public void print() {
	  Node current = head;

	  while (current != null) {
		System.out.println(current.val);
		current = current.next;
	  }
	}

	public void insertInSortedValue(int data) {
	  if (head == null) {
		return;
	  }
	  Node newNode = new Node(data);
	  Node temp = head;
	  while (temp.next != null) {
		if (temp.val <= data && temp.next.val > data) {
		  newNode.next = temp.next;
		  temp.next = newNode;

		  return;
		}
		if (temp.val > data && temp.prev == null) {
		  newNode.next = head;
		  head.prev = newNode;
		  head = newNode;
		  return;
		}
		temp = temp.next;
	  }
	  temp.next = newNode;
	}

	public Node findValue(int val) {
	  Node current = head;

	  while (current.next != null) {
		if (current.val == val) {
		  return current;
		}
		current = current.next;
	  }
	  return current;
	}


	static class Node {
	  public int val;
	  public Node next;
	  public Node prev;

	  public Node(int val) {
		this.val = val;
	  }

	  @Override
	  public String toString() {
		return "val=" + val;
	  }
	}
  }
}
