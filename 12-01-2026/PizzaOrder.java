/*
    Scenario: Pizza Order Validator
        You're building the backend logic for a pizza ordering system.
        Each order includes:

        A list of toppings (e.g., "Pepperoni", "Mushrooms")
        A size ("SMALL", "MEDIUM", or "LARGE")

    🚫 Business Rules:

        Small pizzas can have at most 2 toppings.
        Medium pizzas can have at most 3 toppings.
        Large pizzas can have up to 5 toppings.
        "Pineapple" cannot be ordered with "Ham" (controversial combo!).
    
    🎯 Your Task
    
        Create a Java method isValidOrder(List<String> toppings, String size) that returns true if the order follows all rules, otherwise false.

 */

import java.util.*;

class Order {

    boolean isValidOrder(List<String> tops, String size) {
        boolean re = false;
        if (tops.size() == 2 && size.equals("SMALL")) {
            re = true;
        } else if (tops.size() == 3 && size.equals("MEDIUM")) {
            re = true;
        } else if (tops.size() == 5 && size.equals("LARGE")) {
            re = true;
        }
        return re;

    }
}

class PizzaOrder {

    public static void main(String[] args) {

        String size, top;
        boolean temp;
        try (Scanner inp = new Scanner(System.in)) {
            System.out.print("Enter the size of the Pizza (\"SMALL\", \"MEDIUM\", or \"LARGE\") : ");
            size = inp.next();
            System.out.print("Enter the Toppings(Separated by comma ( , )): ");
            top = inp.next();
            List<String> toppings = new ArrayList<>(Arrays.asList(top.split(",")));

            Order or = new Order();
            size = size.toUpperCase();
            temp = or.isValidOrder(toppings, size);
            if (temp) {
                System.out.printf("Your Order for the %s is Accepted...", size);
            } else {
                System.out.printf("Your Order for the %s is Not Accepted...", size);
            }
        }
    }
}
