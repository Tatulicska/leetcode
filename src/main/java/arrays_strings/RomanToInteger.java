package arrays_strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
  public static void main(String[] args) {
	System.out.println(romanToInt("III"));
	System.out.println(romanToInt("LVIII"));
	System.out.println(romanToInt("MCMXCIV"));
  }

  public static int romanToInt(String s) {
	if(s == null || s.equals("")){
	  return 0;
	}
	Map<Character, Integer> map = new HashMap<>();
	map.put('I', 1);
	map.put('V', 5);
	map.put('X', 10);
	map.put('L', 50);
	map.put('C', 100);
	map.put('D',500);
	map.put('M',1000);


	String temp = s.toUpperCase();
	int prev = map.get(temp.charAt(0));
	int next = 0;
	int sum =0;

	for(int i=1;i<s.length();i++){
	  next= map.get(temp.charAt(i));
	  if(prev<next){
		sum =sum  - prev;
	  }else{
		sum = sum + prev;
	  }
	  prev = next;

	}
	sum = sum + prev;
	return sum;
  }
}
