package arrays_strings;

import java.util.HashMap;
import java.util.Map;
//SLIDING WINDOW PROBLEM
//Given a string s, find the length of the longest substring without repeating characters.
public class LongestUniqueSubstring {

  public static void main(String[] args) {
	System.out.println(lengthOfLongestSubstring("asweraknuty"));//sweraknuty
	System.out.println(lengthOfLongestSubstring("abcabcbb"));//abc
	System.out.println(lengthOfLongestSubstring("bbbbb"));//b
	System.out.println(lengthOfLongestSubstring("pwwkew"));//wke
	System.out.println(lengthOfLongestSubstring("abba"));//ab
  }
//  the basic idea is, keep a hashmap which stores the characters
//  in string as keys and their positions as values, and keep two pointers which define
//  the max substring. move the right pointer to scan through the string , and meanwhile
//  update the hashmap. If the character is already in the hashmap, then move the left
//  pointer to the right of the same character last found. Note that the two pointers can only move forward.
  public static int lengthOfLongestSubstring(String s) {
	if (s.length()==0) return 0;
	Map<Character, Integer> map = new HashMap<>();
	int max=0;
	for (int i=0, j=0; i<s.length(); ++i){
	  if (map.containsKey(s.charAt(i))){
		j = Math.max(j,map.get(s.charAt(i))+1); // char at i may be smaller than j, so we need to make sure j is bigger than char.at i
	  }
	  map.put(s.charAt(i),i);
	  max = Math.max(max, i-j+1);
	}
	return max;
  }
}
//i-j+1 is the window size, and we try to find the largest size
//if map.get(s.charAt(i))+1 < j, that means the last time we saw this char was outside of the window, so we don't count it.
//"abbbba" is an example. At index 5, we saw 'a', the last time 'a' appeared at index 0. The valid window should be 'ba', i.e i=5 and j=4
