package arrays_strings;

import java.util.Arrays;

public class ReverseString {

  public static void main(String[] args) {
	System.out.println(reverse("tatia"));//aitat
	System.out.println(reverse("tatuskas"));//saksutat
  }

  private static String reverse(String str) {
	char[] chars = str.toCharArray();
	for(int i = 0; i<chars.length/2; i++){
	  char temp = chars[i];
	  chars[i]=chars[chars.length-i-1];
	  chars[chars.length-i-1] = temp;
	}
	return Arrays.toString(chars);
  }
}
