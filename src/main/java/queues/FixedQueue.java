package queues;


// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

/*
Implement a fixed-capacity queue that uses a fixed-sized array for storage. The queue should have one method to add a new element and another that both removes an element and returns it.
*/


class FixedQueue {//[0,0,0],[1,0,0],[1,1,0]


    /*

    [1,2,3]
    [-,2,3]
    [-,-,3]
    [4,-,3]
    [4,-,-]
    [4,5,-]
    */

  int[] arr;
  int size;
  int count;
  int indexOfLast;
  int indexOfFirst;

  public FixedQueue(int size){
	this.size=size;
	arr = new int[size];
	this.indexOfLast=0;
	this.indexOfFirst=0;
  }


  public void add(int n){
	if(isFull()){
	  throw new RuntimeException("queue is full");
	}
	arr[indexOfLast]=n;
	indexOfLast = (indexOfLast+1) % size;

	count++;

  }

  public int remove(){//remove 1st el
	if(isEmpty()){
	  throw new RuntimeException("queue is empty");
	}

	int result = arr[indexOfFirst];
	arr[indexOfFirst]=0;
	indexOfFirst = (indexOfFirst+1) % size;
	count--;
	return result;

  }

  private boolean isFull(){
	return count==size;
  }

  private boolean isEmpty(){
	return count == 0;
  }

  public void print(){
	for (int j : arr) {
	  System.out.print(j);
	}
  }

  public static void main(String[] args) {
	System.out.println("Hello, world!");
	FixedQueue queue = new FixedQueue(3);
	queue.add(1);
	queue.add(2);
	queue.add(3);
	System.out.println(queue.remove());
	System.out.println(queue.remove());
	queue.add(4);
	queue.add(5);
	// 4,5,3
	System.out.println(queue.remove());
	System.out.println(queue.remove());
	// 0,5,0


	queue.print();

  }
}
