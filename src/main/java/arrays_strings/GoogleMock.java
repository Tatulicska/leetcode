package arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleMock {

  public static void main(String[] args) {
	List<String> lit = Arrays.asList("tati@mail.o","lalalala@mail.ok","ta.ti@mail.o","tati+smati@mail.o","lalalala+kkk@mail.ok");
	System.out.println(findMostCommonEmail(lit));
  }

  private static String findMostCommonEmail(List<String> lit) {
	Map<String,Integer> map = new HashMap<>();
	int maxOcc = 0;
	String result = "";
	for (String email: lit) {
	  String emailNoDots = email.substring(0, email.indexOf("@")).replaceAll("\\.","")+email.substring(email.indexOf("@"));
	  String emailNoPLus = emailNoDots;
	  if(emailNoPLus.contains("+")){
		emailNoPLus = emailNoDots.substring(0, emailNoDots.indexOf("+")) + emailNoDots.substring(emailNoDots.indexOf("@"));
	  }

	  map.put(emailNoPLus, map.getOrDefault(emailNoPLus, 0)+1);

	  if(map.get(emailNoPLus)>maxOcc){
		maxOcc = map.get(emailNoPLus);
		result = emailNoPLus;
	  }
	}
	return result;
  }
}
