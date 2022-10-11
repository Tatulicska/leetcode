package queues;


import java.util.PriorityQueue;

//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//    Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//    You must solve it in O(n) time complexity.
class KthLargest {
  public static void main(String[] args) {
	int[] nums = {3, 2, 1, 5, 6, 4};
	int k = 2;
	System.out.println(findKthLargest(nums, k));
  }

  public static int findKthLargest(int[] nums, int k) {
	int size = nums.length;
	if (size < k) {
	  return 0;
	}
	PriorityQueue<Integer> q = new PriorityQueue<>();
	for (int i : nums) {
	  q.add(i);
	  if (q.size() > k) {
		q.remove();
	  }
	}
	return q.remove();
  }
}

