package queues;

public class QueueArray {

  private int frontIndex;

  private int backIndex;

  private final int capacity;

  private final int[] arr;

  public QueueArray(int capacity) {
	this.capacity = capacity;
	arr = new int[capacity];
	frontIndex = -1;
	backIndex = -1;
  }

  //An operation to insert an element in the queue in the rear end (back)
  public void enqueueQueue(int x){
	if(isFull()){
	  throw new IllegalArgumentException("queue is full");
	}
	if(frontIndex == -1){
	  frontIndex = 0;
	}
	arr[++backIndex] = x;
  }

  // operation to delete an element from front of the queue
  public void dequeueQueue(){
	if(isEmpty()){
	  throw new IllegalArgumentException("queue is empty");
	}
	for (int i = 0; i < backIndex; i++) {
	  arr[i]  = arr[i+1];
	}
	if(backIndex<capacity){
	  arr[backIndex] = 0;
	  backIndex--;
	}
  }

  public boolean isEmpty(){
	return frontIndex == -1;
  }

  private boolean isFull(){
	return capacity == backIndex + 1;
  }

  public void print(){
	for (int i = 0; i < capacity; i++) {
	  System.out.println(arr[i]);
	}
  }

  public static void main(String[] args) {
	QueueArray q = new QueueArray(5);
	q.enqueueQueue(2);
	q.dequeueQueue();
	q.enqueueQueue(3);
	q.enqueueQueue(4);
	q.enqueueQueue(5);
	q.enqueueQueue(6);
	q.dequeueQueue();
	q.enqueueQueue(7);
	q.enqueueQueue(8);
	q.print();
  }
}
