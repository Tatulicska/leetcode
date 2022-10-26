package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//improved version of Queue will use explicit locking, to improve the multi-threading performance.
// Lock and Condition interface provides much better flexibility compared to intrinsic locking mechanism,
// but this flexibility brings more responsibility as we have to take care of calling lock and unlock ourselves.
// Since one lock can be associated with multiple conditions (notFull & notEmpty in this case),
// this results in better throughput due to lesser thread contention.
//Here we are using ReentrantLock along with Condition to explicitly define the lock.
// This reduces thread contention under heavy load circumstances.
//
//	We can do few further improvements to the above version, for example we can use
//	LinkedList instead of array and optionally make it generic to support any item type.
public class BlockingQueue<T>{
  private final Queue<T> queue = new LinkedList<T>();
  private final int capacity;
  private final Lock lock = new ReentrantLock();
  private final Condition notFull = lock.newCondition();
  private final Condition notEmpty = lock.newCondition();

  public BlockingQueue(int capacity) {
	this.capacity = capacity;
  }

  public void put(T element) throws InterruptedException {
	lock.lock();
	try {
	  while (queue.size() == capacity) {
		notFull.await();
	  }
	  queue.add(element);
	  notEmpty.signal();
	} finally {
	  lock.unlock();
	}
  }

  public T take() throws InterruptedException {
	lock.lock();
	try {
	  while (queue.isEmpty()) {
		notEmpty.await();
	  }
	  T item = queue.remove();
	  notFull.signal();
	  return item;
	} finally {
	  lock.unlock();
	}
  }
}
