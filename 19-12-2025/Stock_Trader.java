
import java.util.*;

public class Stock_Trader {

    public static void main(String[] a) {

        try (Scanner inp = new Scanner(System.in)) {
            System.out.print("Enter the day (1-7) to buy the stock : ");
            int pri = inp.nextInt();

            if (pri == 7) {
                System.out.println("Sorry, u cant able to buy the product at the weekends....");
                return;
            }

            Integer[] prices = {200, 300, 800, 400, 900, 100, 150};

            // int minprice = prices[pri];
            int minprice = Collections.max(Arrays.asList(prices));
            int maxprofit = 0;

            for (int i : prices) {
                if (i < minprice) {
                    minprice = i;
                } else {
                    int temp = Math.abs(i - minprice);
                    if (temp > maxprofit) {
                        maxprofit = temp;
                    }
                }
            }
            System.out.println("Profit for buying the stock and sell in that week : " + maxprofit);
        }

    }

}
