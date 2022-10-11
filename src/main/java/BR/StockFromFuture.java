package BR;

public class StockFromFuture {

  public static void main(String[] args) {
	int[] input = {5};
	String res = computeBestTransaction(input);
	System.out.println(res);
  }

  /*
   * Complete the function below.
   */
  static String computeBestTransaction(int[] data) {
	int maxDiff = 0;
	int buy = data[0];
	int sell = data[0];
	int dayBuy = 0;
	int daySell = 0;
	for (int i = 0; i < data.length; i++) {
	  for (int j = 0; j <i; j++) {
		int diff = data[i]-data[j];
		if(diff > maxDiff){
		  maxDiff = diff;
		  dayBuy = j;
		  daySell = i;
		  sell = data[i];
		  buy = data[j];
		}
	  }
	}
	return formatOutput(buy, dayBuy+1, sell, daySell+1, maxDiff);
  }

  static String formatOutput(int buyPrice, int buyDay, int sellPrice, int sellDay, int perShareProfit) {
	return "BUY@" + buyPrice + " on day " + buyDay + " and SELL@" + sellPrice + " on day " + sellDay +
		".  For a profit of $" + perShareProfit + " per share!";
  }
}
