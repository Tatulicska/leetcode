package stacks;

public class StackArray {

  private final int[] arr;
  private int topIndex;
  private final int capacity;

  public StackArray(int i) {
	capacity = i;
	arr = new int[capacity];
	topIndex = -1; // If the stack has no element is known as an empty stack. When the stack is empty the value of the topIndex variable is -1.
  }

  public void push(int x){
	if(isFull()){
	  return;
	}
	topIndex++;
	arr[topIndex] = x;
  }

  private boolean isFull() {
	return topIndex == capacity-1;
  }

  //removes the last element from an array and returns that element.
  public int pop(){
	if(isEmpty()){
	  return -1;//ERROR or anything
	}
	return arr[topIndex--];
  }

  public int size(){
	return ++topIndex;
  }

  public boolean isEmpty(){
	return topIndex == -1;
  }

  private void print() {
	for (int i=0; i<= topIndex; i++) {
	  System.out.println(arr[i]);
	}
  }

  public static void main(String[] args) {
	StackArray stack = new StackArray(5);
	stack.push(4);
	stack.push(3);
	stack.push(6);
	stack.push(123);
	stack.push(8765);
	stack.pop();
	stack.print();
  }


}
