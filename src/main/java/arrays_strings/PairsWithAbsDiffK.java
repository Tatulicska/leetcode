package arrays_strings;

//Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.
//Input: nums = [1,2,2,1], k = 1
//	Output: 4

import java.util.HashMap;
import java.util.Map;

public class PairsWithAbsDiffK {
  public static void main(String[] args) {
	int[] nums = {1,2,2,1};
	System.out.println(countKDifferenceFasterTime(nums, 1));
  }

  public static int countKDifference(int[] nums, int k) {
	if(nums.length == 0){
	  return 0;
	}
	int countPairs = 0;
	for(int i=0; i<nums.length;i++){
	  for(int j = i+1; j< nums.length; j++){
		if(Math.abs(nums[i]-nums[j])==k){
		  countPairs++;
		}
	  }
	}
	return countPairs;
  }

  public static int countKDifferenceFasterTime(int[] nums, int k) {
	Map<Integer,Integer> map = new HashMap<>();
	int res = 0;

	for (int num : nums) {
	  if (map.containsKey(num - k)) {
		res += map.get(num - k);
	  }
	  if (map.containsKey(num + k)) {
		res += map.get(num + k);
	  }
	  map.put(num, map.getOrDefault(num, 0) + 1);
	}


	return res;
  }
}
