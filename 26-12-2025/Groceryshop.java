/*

    Yu're coding the logic for a grocery store’s dynamic discount engine.
    The store offers a 10% discount on the total bill only if both of the following conditions are met:

        The customer buys at least 5 different items.
        The total price before discount is $50 or more.

 */
import java.util.*;

public class Groceryshop {

    public static void main(String[] args) {

        Map<String, Double> it = new HashMap<>();

        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n--------Grocery Shop --------\n1.Add Items\n2.Bill\n3.Exit\n");
                System.out.print("Enter the choice : ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter item name : ");
                        String its = sc.next();
                        System.out.print("Enter the Price : ");
                        Double pri = sc.nextDouble();
                        it.put(its, pri);
                    }
                    case 2 -> {
                        Double total = 0.0;
                        for (Double ele : it.values()) {
                            total += ele;
                        }
                        if (it.size() >= 5 && total >= 500) {
                            Double re = total * 0.1;
                            System.out.println("Total Bill Amount : " + (total - re));
                        } else {
                            System.out.println("Total Bill Amount : " + total);
                        }

                    }
                    case 3 -> {
                        return;
                    }
                    default ->
                        System.out.println("Invalid Choice");
                }
            }

        }

    }
}
