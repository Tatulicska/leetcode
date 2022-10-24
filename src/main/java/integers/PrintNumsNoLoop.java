package integers;

public class PrintNumsNoLoop {

  public static void main(String[] args) {
	printNum(100);
	printNumReverse(100);
  }

  private static void printNumReverse(int i) {
	if(i == 0){
	  return;
	}
	System.out.println(i);
	printNumReverse(--i);
  }

  private static void printNum(int i) {
	if(i == 0){
		return;
	}
	printNum(--i);
	System.out.println(i);
  }
}
