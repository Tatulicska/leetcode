package arrays_strings;

//Given two arrays of unbounded length, return the sum of the minimum values of both
public class SumMinOfArrays {

  public static void main(String[] args) {
	int[] nums1 = {9, 34, 21};
	int[] nums2 = {3, 5, 6, -8};
	System.out.println(sumArraysMin(nums1, nums2));
  }

  private static int sumArraysMin(int[] nums1, int[] nums2) {
	int min1 = Integer.MAX_VALUE;
	int min2 = Integer.MAX_VALUE;
	int i = 0;
	int j = 0;

	do {
	  if (i < nums1.length && nums1[i] < min1) {
		min1 = nums1[i];
	  }
	  if (j < nums2.length && nums2[i] < min2) {
		min2 = nums2[j];
	  }
	  i++;
	  j++;
	} while (i < nums1.length || j < nums2.length);


	if (nums1.length == 0) {
	  min1 = 0;
	}
	if (nums2.length == 0) {
	  min2 = 0;
	}
	return min1 + min2;
  }
}
