package binary;
//todo with bits shifting topic

public class HammingWeight {

  public static void main(String[] args) {
	System.out.println(hammingWeight(Integer.parseInt("00000000000000000000000000001011")));
  }

  public static int hammingWeight(int n) {
	String num = String.valueOf(n);
	int res = 0;
	for(char c: num.toCharArray()){
	  if(c == 1){
		res++;
	  }
	}
	return res;
  }
}
