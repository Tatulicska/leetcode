package integers;

public class PalindromeInteger {
  public static void main(String[] args) {
	System.out.println(isPalindrome(123454321));
  }

  private static boolean palindromeInt(int x) {
	if(x>0 && x<10){
	  return true;
	}
	if(x<0 || x%10==0){
	  return false;
	}
	int reversed = 0;
	while(x>reversed){
	  int mod = x % 10;
	  x = x/10;
	  reversed = reversed * 10 + mod;
	}
	if(reversed>x){
	  reversed = reversed/10;
	}
	return x == reversed;
  }

  public static boolean isPalindrome(int x){
	if(x < 0) return false;
	int temp = x;
	int result = 0;
	while(temp != 0) {
	  result = result * 10 + temp % 10;
	  temp /= 10;
	}
	return x == result;
  }
}
