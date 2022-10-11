package BR;

import static java.util.stream.Collectors.toList;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class Solution {

  /**
   * You have a list of passwords and just one chance to enter the correct one.
   * <p>
   * You are provided with the so-called "check string", where:
   * + The first character is a digit that represents the number of uppercase symbols in the correct password.
   * + The next 3 characters are last 3 characters of the correct password in reverse order.
   * + The last characters represent the sum of all digits in the password.
   * <p>
   * Find the correct password.
   * <p>
   * Examples:
   * <p>
   * Input: [P@sswORD1,20passWORD20,PASS6word] , 4dro6
   * Output: PASS6word
   * <p>
   * Input: [theBestpassword,myPassword#3], 1dro0
   * Output: theBestpassword
   * <p>
   * Input: [MyPassword2, crazyPassword1#$%], 1%$#1
   * Output: crazyPassword1#$%
   * <p>
   * Input: [luckyPASSWORD#$$$, luckyDay666], 6pass7
   * Output:
   */

  public static void main(String[] args) throws IOException {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	int n = Integer.parseInt(bufferedReader.readLine().trim());

	List<String> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//		.map(String::parseInt)
		.collect(toList());


	password(arr, "");
	bufferedReader.close();
  }

  private static String password(List<String> passwords, String checkString) {
	if (passwords.size() == 0 || checkString.length() != 5) {
	  return "";
	}
	int expectedUppercaseChars = Integer.parseInt(checkString.substring(0, 1));
	String lastChars = new StringBuilder(checkString.substring(1, 4)).reverse().toString();
	int expectedSumOfDigits = Integer.parseInt(checkString.substring(4, 5));
	for (String password : passwords) {
	  if (password.endsWith(lastChars)) {
		int actualSumOfDigits = 0;
		int actualUppercaseChars = 0;
		for (char c : password.toCharArray()) {
		  if (Character.isDigit(c)) {
			actualSumOfDigits += Character.getNumericValue(c);
		  } else if (Character.isUpperCase(c)) {
			actualUppercaseChars++;
		  }
		}
		if (expectedSumOfDigits == actualSumOfDigits && expectedUppercaseChars == actualUppercaseChars) {
		  return password;
		}
	  }
	}
	return "No valid password";
  }
}
