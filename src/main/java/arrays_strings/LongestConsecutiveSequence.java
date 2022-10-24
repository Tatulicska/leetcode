package arrays_strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//	You must write an algorithm that runs in O(n) time.
//
//
//
//	Example 1:
//
//	Input: nums = [100,4,200,1,3,2]
//	Output: 4
//	Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//	Example 2:
//
//	Input: nums = [0,3,7,2,5,8,4,6,0,1]
//	Output: 9
public class LongestConsecutiveSequence {

  public static void main(String[] args) {
	int nums[] = {3,7,2,9,8,7,5,10,6,3};
	System.out.println(longestConsecutiveFaster(nums));
  }

//  Time complexity : O(nlgn)O(nlgn).

//  The main for loop does constant work n times, so the
//  algorithm's time complexity is dominated by the invocation of sort, which will run in O(nlgn) time for any sensible implementation.
  public static int longestConsecutive(int[] nums) {
	if (nums.length == 0) {
	  return 0;
	}
	Arrays.sort(nums);
	int count = 0;
	int maxCount = 0;
	for (int i = 0; i < nums.length - 1; i++) {
	  if (Math.abs(nums[i + 1] - nums[i]) > 1) {
		if(count>maxCount){
		  maxCount = count;
		}
		count = 0;
		continue;
	  }else if(nums[i + 1] == nums[i]){
		continue;
	  }
	  count++;
	}
	return Math.max(maxCount, count)+1;
  }

//  O(n)
//  Although the time complexity appears to be quadratic due to the while loop nested within the for loop,
//  closer inspection reveals it to be linear. Because the while loop is reached only when currentNum
//  marks the beginning of a sequence (i.e. currentNum-1 is not present in nums), the while loop can
//  only run for nn iterations throughout the entire runtime of the algorithm. This means that despite
//  looking like O(n \cdot n)O(n⋅n) complexity, the nested loops actually run in O(n + n) = O(n)O(n+n)=O(n)
//  time. All other computations occur in constant time, so the overall runtime is linear.
  public static int longestConsecutiveFaster(int[] nums) {
	Set<Integer> set = new HashSet<>();
	for(int n : nums) {
	  set.add(n);
	}
	int max = 0;
	for(int current : set) {
//	  first ensuring that the number that would immediately precede the current number
//	  in a sequence is not present, as that number would necessarily be part of a longer sequence.
	  if(!set.contains(current - 1)) {  // only check for one direction
		int next = current + 1;
		while(set.contains(next)) {
		  next++;
		}
		max = Math.max(max, next - current);
	  }
	}
	return max;
  }
}
