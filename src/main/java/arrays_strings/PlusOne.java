package arrays_strings;

//Input: digits = [1,2,3]
//	Output: [1,2,4]
//	Explanation: The array represents the integer 123.
//	Incrementing by one gives 123 + 1 = 124.
//	Thus, the result should be [1,2,4].
public class PlusOne {

  public static void main(String[] args) {
//	int [] nums = {1,2,3,9};
	int [] nums = {9};
	plusOne(nums);
  }

  public static int[] plusOne(int[] digits) {
	int n = digits.length;
	for(int i=n-1;i>=0;i--){
	  if(digits[i]<9){
		digits[i]+=1;
		return digits;
	  }
	  digits[i]=0;
	}

	int[] newDigits = new int[n+1];
	newDigits[0]=1;
	return newDigits;
  }
}
