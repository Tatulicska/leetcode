package lists;

public class Linkedlist {

  public static void main(String[] args) {
	MyLinkedList linkedList1 = new Linkedlist().createLinkedList();
	MyLinkedList linkedList2 = new Linkedlist().createLinkedList2();
	MyLinkedList.Node node = oddEvenList(linkedList1.head);
	System.out.println();
  }

  private static MyLinkedList.Node oddEvenList(MyLinkedList.Node head) { //we store odd values in here
	if(head == null){
	  return null;
	}

	MyLinkedList.Node odd = head;//loop thru odds
	MyLinkedList.Node even = head.next;//loop thru evens
	MyLinkedList.Node evenHead = head.next;//we store even values here

	// `even != null` rules out the list of only 1 node
	// `even.next != null` rules out the list of only 2 nodes
	while (even != null && even.next != null) {
	  // Put odd to the odd list
	  odd.next = odd.next.next;
	  // Put even to the even list
	  even.next = even.next.next;

	  // Move the pointer to the next odd/even
	  odd = odd.next;
	  even = even.next;
	}
	odd.next = evenHead;
	return head;
  }

  private static MyLinkedList.Node removeNthNodeFromEnd(MyLinkedList.Node head, int n) {
	MyLinkedList.Node start = new MyLinkedList.Node(0);
	start.next = head;
	MyLinkedList.Node slow = start, fast = start;

	//Move fast in front so that the gap between slow and fast becomes n
	for(int i=1; i<=n+1; i++)   {
	  fast = fast.next;
	}
	//Move fast to the end, maintaining the gap
	while(fast != null) {
	  slow = slow.next;
	  fast = fast.next;
	}
	//Skip the desired node
	slow.next = slow.next.next;
	return start.next;
  }

  private static boolean palindromeLinkedList(MyLinkedList.Node head) {
	MyLinkedList.Node slow = head;
	MyLinkedList.Node fast = head;

	while (fast != null && fast.next != null) {
	  fast = fast.next.next;
	  slow = slow.next;
	}
	slow = reverse(slow);
	fast = head;

	while(slow != null && fast != null){
	  if(slow.val != fast.val){
		return false;
	  }
	  slow = slow.next;
	  fast = fast.next;
	}
	return true;
  }

  private static MyLinkedList.Node reverse(MyLinkedList.Node head) {
	MyLinkedList.Node prev = null;

	while(head != null){
	  MyLinkedList.Node next = head.next;
	  head.next = prev;
	  prev = head;
	  head = next;
	}
	return prev;
  }

  private static MyLinkedList.Node mergeTwoLists(MyLinkedList.Node node1, MyLinkedList.Node node2) {
	MyLinkedList.Node dummy = new MyLinkedList.Node(0);
	MyLinkedList.Node head = dummy;

	while (node1 != null || node2 != null) {
	  if (node1 != null && node1.val < node2.val) {
		dummy.next = node1;
		node1 = node1.next;
	  } else {
		dummy.next = node2;
		node2 = node2.next;
	  }
	  dummy = dummy.next;
	}
	return head.next;
  }

  private static MyLinkedList.Node addUpReverseLists(MyLinkedList.Node list1, MyLinkedList.Node list2) {
	if (list2 == null) {
	  return list1;
	}
	if (list1 == null) {
	  return list2;
	}
	int carry = 0;
	MyLinkedList.Node dummy = new MyLinkedList.Node(0);
	MyLinkedList.Node head = dummy;

	while (list1 != null || list2 != null) {
	  int sum;
	  if (list1 == null) {
		sum = list2.val + carry;
		list2 = list2.next;
	  } else if (list2 == null) {
		sum = list1.val + carry;
		list1 = list1.next;
	  } else {
		sum = list1.val + list2.val + carry;
		list1 = list1.next;
		list2 = list2.next;
	  }
	  if (sum > 9) {
		carry = sum / 10;
		sum = sum % 10;
	  } else {
		carry = 0;
	  }
	  dummy.next = new MyLinkedList.Node(sum);
	  dummy = dummy.next;
	}
	if (carry > 0) {
	  dummy.next = new MyLinkedList.Node(carry);
	}
	return head.next;
  }

  private MyLinkedList createLinkedList() {
	MyLinkedList list1 = new MyLinkedList();
	list1.addAtHead(1);
	list1.addAtTail(2);
	list1.addAtTail(3);
	list1.addAtTail(4);
	list1.addAtTail(5);
	list1.addAtTail(6);
	list1.addAtTail(7);
	return list1;
  }

  private MyLinkedList createLinkedList2() {
	MyLinkedList list1 = new MyLinkedList();
	list1.addAtTail(9);
	list1.addAtTail(9);
	list1.addAtTail(9);
	list1.addAtTail(9);
	list1.addAtTail(9);
	list1.addAtTail(9);
	list1.addAtTail(9);
	return list1;
  }

  static class MyLinkedList {
	private Node head;

	public MyLinkedList() {
	  head = null;
	}


	public void reverseList() {
	  Node current = head;    //1->2->3->4
	  Node prev = null;

	  while (current != null) {
		Node next = current.next;
		current.next = prev;
		prev = current;
		current = next;
	  }
	  head = prev;
	}

	public void printReverse() {
	  printReverse(head);
	}

	private void printReverse(Node node) {
	  if (node == null) {
		return;
	  }
	  printReverse(node.next);
	  System.out.println(node.val);

	}

	public void print() {
	  if (head == null) {
		return;
	  }
	  System.out.println(head.val);
	  head = head.next;
	  print();
	}

	public int get(int index) {
	  if (head == null) {
		return 0;
	  }
	  Node current = head;
	  int i = 0;
	  for (; i < index && current.next != null; i++) {
		current = current.next;
	  }
	  if (index > i) {
		return -1;
	  }

	  return current.val;
	}

	public void addAtHead(int val) {
	  Node current = new Node(val);
	  current.next = head;
	  head = current;
	}

	public void addAtTail(int val) {
	  Node tail = new Node(val);
	  if (head == null) {
		head = tail;
		return;
	  }
	  Node current = head;
	  while (current.next != null) {
		current = current.next;
	  }
	  current.next = tail;

	}

	public void addAtIndex(int index, int val) {
	  if (head == null && index > 0) {
		return;
	  }
	  Node newNode = new Node(val);
	  if (index == 0) {
		newNode.next = head;
		head = newNode;
		return;
	  }
	  Node current = head;
	  int i = 1;
	  for (; i < index && current.next != null; i++) {
		current = current.next;
	  }
	  if (index > i) {
		return;
	  }
	  if (current != null) {
		newNode.next = current.next;
		current.next = newNode;
	  }

	}

	public void deleteAtIndex(int index) {
	  if (head == null) {
		return;
	  }
	  Node current = head;
	  if (index == 0) {
		head = head.next;
		return;
	  }
	  int i = 1;
	  for (; i < index && current.next != null; i++) {
		current = current.next;
	  }
	  if (index > i) {
		return;
	  }
	  if (current.next != null) {
		current.next = current.next.next;
	  }
	}

	public int getAtFromTail(int at) {
	  if (head == null) {
		return 0;
	  }
	  Node current = head;
	  int length = 0;

	  while (current != null) {
		length++;
		current = current.next;
	  }

	  Node res = head;
	  for (int i = 0; i < length - 1 - at; i++) {
		res = res.next;
	  }
	  return res.val;
	}

	/**
	 * from sorted list
	 */
	public void deleteDuplicatesSorted() {
	  if (head == null) {
		return;
	  }
	  Node current = head;

	  while (current.next != null) {
		if (current.val == current.next.val) {
		  current.next = current.next.next;//update
		} else {
		  current = current.next;//reassign
		}
	  }
	}

	/**
	 * from sorted list
	 */
	public void deleteDuplicatesSortedKeepDistinct() { //1,1,1,2,3 ---> 2,3
	  if (head == null) {
		return;
	  }
	  Node fakeHead = new Node(0);//insert as first node and make head next
	  fakeHead.next = head;
	  Node pre = fakeHead; //make previous head and set current to head which is second now
	  Node cur = head;
	  while (cur != null) {
		while (cur.next != null && cur.val == cur.next.val) {
		  cur = cur.next; //loop thru all duplicates until last one
		}
		if (pre.next == cur) {
		  pre = pre.next; //if next isnt duplicate just step ahead
		} else {
		  pre.next = cur.next; //otherwise skip whole group of duplicates
		}
		cur = cur.next; //go on
	  }
	  head = fakeHead.next; //skip init 0 value and return the rest
	}

	public void deleteDuplicatesUnsorted() {
	  if (head == null) {
		return;
	  }
	  Node previous = head;
	  Node current = head.next;
	  while (current != null) {
		Node runner = head;
		while (runner != current) { // Check for earlier dups
		  if (runner.val == current.val) {
			Node tmp = current.next; // remove current
			previous.next = tmp;
			current = tmp; // update current to next node
			break; // all other dups have already been removed
		  }
		  runner = runner.next;
		}
		if (runner == current) { // current not updated - update now
		  previous = current;
		  current = current.next;
		}
	  }
	}

	@Override
	public String toString() {
	  return "MyLinkedList{" +
		  "head=" + head +
		  '}';
	}

	public Node findValue(int i) {
	  if (head == null) {
		return null;
	  }
	  Node current = head;
	  while (current.next != null) {
		if (current.val == i) {
		  return current;
		}
		current = current.next;
	  }
	  return current;
	}

	private static class Node {
	  public int val;
	  public Node next;

	  public Node(int val) {
		this.val = val;
	  }

	  @Override
	  public String toString() {
		Integer integer = next != null ? next.val : null;
		return "Node{" +
			"val=" + val +
			", next=" + integer +
			'}';
	  }
	}
  }
}





