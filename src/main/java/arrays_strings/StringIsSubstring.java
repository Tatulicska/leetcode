package arrays_strings;

public class StringIsSubstring {

//  Assume you have a method isSubstring which checks if one word is
//  a substring of another. Given two strings, s1 and s2, write code to
//  check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
  public static void main(String[] args) {
	//System.out.println(substring("waterbottle","erbottlewat"));
	System.out.println(substring("tatika","katati"));
  }

  private static boolean substring(String s1, String s2) {
	if((s1.length() != s2.length()|| s1.equals("") || s2.equals(""))){
	  return false;
	}

	return (s1 + s1).contains(s2);
  }
}
