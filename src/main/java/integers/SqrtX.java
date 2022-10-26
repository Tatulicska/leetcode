package integers;

//Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
//
//	You must not use any built-in exponent function or operator.
//
//	For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
//Input: x = 8
//	Output: 2
//	Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
public class SqrtX {

  public static void main(String[] args) {
	System.out.println(squareRoot(81));
  }
//binary search
  private static int squareRoot(int n) {
	if(n<2){
	  return n;
	}
	int start = 1;
	int end = n;
	while (start < end){
	  int mid = (start+end)/2;
	  if(mid <= n/mid && (mid +1)>n/(mid+1)){//found the result
		return mid;
	  }
	  if(mid > n/mid){
		end = mid;//keep checking the left part
	  } else {
		start = mid +1; //keep checking the right part
	  }
	}
	return start;
  }
}
//  For folks wondering what is the (mid + 1) > x / (mid + 1) for:      (try 81 with and wo this condition)
//
//	There are comments on threads where it is mentioned: it is to prevent overflow.
//	But they do not mention how integers overflow in Java. Let me tell you why:
//	In a nutshell, they overflow in a circular fashion.
//	Meaning if you do Integer.MAX_VALUE + 1 it will yield Integer.MIN_VALUE. Same for the other way around.
//	Try printing these expressions in a Java program to really see it in action.
//
//	So when we found our value mid <= x / mid, it is important to check if it is not overflowing.
//	If it overflows, then it rolls over to the negative integers and thus the value of mid + 1 can never be greater than x/mid + 1
