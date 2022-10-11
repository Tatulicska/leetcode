package arrays_strings;

import java.util.Arrays;

public class AnagramStrings {
  public static void main(String[] args) {
	System.out.println(anagramStrings("rescue", "secure"));
  }

  //Solution #2: Check if the two strings have identical counts for each unique char.
  private static boolean anagramStrings(String str1, String str2) {
	int[] letters = new int[256];
	int uniqueChars = 0;
	int str2Unique = 0;
	for (char c : str1.toCharArray()) { // count number of each char in str1.
	  if (letters[c] == 0) {
		uniqueChars++;
	  }
	  letters[c]++;
	}
	for (int i = 0; i < str2.length(); ++i) {
	  int c = str2.charAt(i);
	  if (letters[c] == 0) { // Found more of char c in str2 than in str1.
		return false;
	  }
	  letters[c]--;
	  if (letters[c] == 0) {
		str2Unique++;
		if (str2Unique == uniqueChars && (i == str2.length() - 1)) {//i is last in a loop
		  // it’s a match if str2 has been processed completely
		  return true;
		}
	  }
	}
	return false;
  }

  private static boolean anagramStrings2(String s1, String s2) {//O(nlogn)
	char[] chars1 = s1.toCharArray();
	Arrays.sort(chars1);
	char[] chars2 = s2.toCharArray();
	Arrays.sort(chars2);
	return Arrays.equals(chars1, chars2);
  }
}
