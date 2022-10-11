package arrays_strings;

public class MergeSortedArray {
//  Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//  Output: [1,2,2,3,5,6]
//  Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//  The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
  public static void main(String[] args) {
	int [] arr1 = {1,2,3,0,0,0};
	int [] arr2 = {2,5,6};
	merge(arr1,3,arr2,3);
  }


//  Initially p1 = m-1 , p2 = n-1 , i = m+n-1
//  So lets takes two pointers that mark the end of 2 arrays and i ,
//  that would be the index at which we are going to write the value ,
//  now we will compare the values at p1 and p2 and write the value that
//  is larger at index i , after writing we decrement the respective indexes .
//  And the another edge case is that if any one of the array is
//  empty arr[i] = [0] , index i-1 and another one is arr[j] = [1,2,3] , index = j-1
//  So if we consider the index as i-1 then it becomes negative , which is ArrayIndexOutOfBounds ,so we have to take index >=0 .
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
	int end1 = m-1;
	int end2 = n-1;
	int i = m+n-1; //last of num1
	while(end2 >=0 ){
	  if(end1 >=0 && nums1[end1] > nums2[end2]){
		nums1[i--] = nums1[end1--];
	  }
	  else{
		nums1[i--] = nums2[end2--];
	  }
	}


	for (int q: nums1) {
	  System.out.println(q);
	}
  }
}
