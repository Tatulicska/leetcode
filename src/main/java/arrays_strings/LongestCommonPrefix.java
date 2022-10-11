package arrays_strings;
//Write a function to find the longest common prefix string amongst an array of strings.
//
//	If there is no common prefix, return an empty string "".
public class LongestCommonPrefix {

  public static void main(String[] args) {
	String[] arr = {"flight","flower","flow"};
	System.out.println(longestCommonPrefix(arr));
  }

  public static String longestCommonPrefix(String[] strs) {
	if(strs.length == 0){
	  return "";
	}
	String maxPref = strs[0];
	for(String s: strs){
	  while(s.indexOf(maxPref) != 0){
		maxPref = maxPref.substring(0, maxPref.length()-1);
		if(maxPref.length() ==0){
		  return "";
		}
	  }
	}
	return maxPref;
  }

}
