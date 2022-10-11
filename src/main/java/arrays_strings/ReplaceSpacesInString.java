package arrays_strings;

//1.5 Write a method to replace all spaces in a string with '%20'.
public class ReplaceSpacesInString {

  public static void main(String[] args) {
	String s = "hi this is tati            ";//spaces in the end to have enough room for replacement element
	ReplaceFun(s.toCharArray(), s.trim().length());
  }

  public static void ReplaceFun(char[] str, int length) {
	int spaceCount = 0, newLength;
	for (int i = 0; i < length; i++) {///identify how many spaces we have
	  if (str[i] == ' ') {
		spaceCount++;
	  }
	}
	newLength = length + spaceCount * 2; //(n-1) where n is %20.length which is 3, and -1 because we need to inseart 3 characters but we have 1 place
	str[newLength] = '\0';//last newLength considered as end point and spaces after arent calculated. like trim()

	for (int i = length - 1; i >= 0; i--) {
	  if (str[i] == ' ') {
		str[newLength - 1] = '0';
		str[newLength - 2] = '2';
		str[newLength - 3] = '%';
		newLength = newLength - 3;
	  } else {
		str[newLength - 1] = str[i];//store whatever we have
		newLength--;
	  }
	}
	System.out.println(str);
  }
}
