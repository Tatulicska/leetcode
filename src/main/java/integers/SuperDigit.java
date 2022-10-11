package integers;
// n=148, k = 3 => digit is 148148148
//super_digit(P) = super_digit(148148148)
//	= super_digit(1+4+8+1+4+8+1+4+8)
//	= super_digit(39)
//	= super_digit(3+9)
//	= super_digit(12)
//	= super_digit(1+2)
//	= super_digit(3)
//	= 3
public class SuperDigit {

  public static void main(String[] args) {
	System.out.println(superDigit("148",3));
  }

  static int superDigit(String number, int k) {
	if (number.length() > 1)
	{
	  long sum = 0;
	  for (int i = 0; i < number.length(); i++)
	  {
		sum += Character.getNumericValue(number.charAt(i));
	  }
	  return superDigit(Long.toString(sum * k), 1);
	}
	else
	  return Character.getNumericValue(number.charAt(0));

  }
}
