package arrays_strings;

public class AddStrings {

  public static void main(String[] args) {    //129
	String a = "466";                         //+ 11
	String b = "899";                        //  140
	System.out.println(addStrings(a, b));
  }

  private static String addStrings(String b, String a) {
	StringBuilder str = new StringBuilder();
	int n = 0;

	int i = a.length() - 1;
	int j = b.length() - 1;

	while (i >= 0 || j >= 0) {
	  int sum = n;
	  if(i>=0){
		sum = sum + a.charAt(i) - '0'; //in ASCII to find how many characters away from 0 our char is
		i--;
	  }
	  if(j>=0){
		sum = sum + b.charAt(j) - '0';
		j--;
	  }
	  if(sum > 9){
		n = sum/10;
		sum = sum%10;
	  }else {
		n=0;
	  }
	  str.append(sum);
	}
	if(n>0){
	  str.append(n);
	}
	return str.reverse().toString();
  }
}
