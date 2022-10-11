package arrays_strings;

import java.util.Arrays;

//Given two strings,s1 and s2, that may not be of the same length,
// determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.
//
//Example.
//s1=abc
//s2=amnop
//The only characters that match are the a's so we have to remove bc from s1and  mnop  from s2 for a total of  deletions.
//return int: the minimum number of deletions needed
public class MakeAnagram {

  public static void main(String[] args) {
	System.out.println(makingAnagrams("abc","amnap"));
  }

  static int makingAnagrams(String s1, String s2) {
	int[] freq = new int[26];
	s1.chars().forEach(c -> freq[c - 'a']++);
	s2.chars().forEach(c -> freq[c - 'a']--);
	return Arrays.stream(freq).map(Math::abs).sum();
  }
}
