package stacks;

//last in first out
//beginning of linked list is the top of the stack
public class StackNode {
  static Node top;

  public static void main(String[] args) {
	push(4);
	push(5);
	push(2);
	push(1);
	push(6);//1->2->5->4
//	pop();//2->5->4
	min();
	System.out.println();
  }

  static public void pop() {
	if (top != null) {
	  top = top.next;
	}
  }

  public static void push(int data) {
	Node next = new Node(data);
	next.next = top;
	top = next;
  }

  public static Node min(){//TODO find min in stack
	if(top == null){
	  return null;
	}

	return null;
  }

  private static class Node {
	int data;
	Node next;
	int min;

	public Node(int data) {
	  this.data = data;

	}
  }
}
