
/*
    Online Shopping Cart with Offers

       -> Maintain a product catalog in a Map<String, Double> (productName → price).

       -> Cart is a List<String> of product names.

       -> Calculate total cost of the cart and apply offers like:

            Buy 2 get 1 free for a specific product.

            Flat 10% off if total > 2000.

       -> Print item-wise bill and final payable amount.
 */
import java.util.*;

class Cart {

    Scanner ip;
    String product;
    int count;
    Double price;

    public Cart(Scanner ip) {
        this.ip = ip;
    }

    Map<String, List<Object>> ad = new HashMap<>();

    void empty() {
        ad.clear();
    }

    void adding() {
        System.out.print("Enter the Product Name : ");
        product = ip.next();

        System.out.print("Enter the No.of Count : ");
        count = ip.nextInt();

        System.out.print("Enter the Price of the Product : ");
        price = ip.nextDouble();
        System.out.println();

        List<Object> productDetails = new ArrayList<>();
        productDetails.add(count);
        productDetails.add(price);

        ad.put(product, productDetails);
    }

    String updatePro;
    int updateCount;
    Double updatePrice;

    void update() {
        System.out.print("Enter the Product Name : ");
        updatePro = ip.next();

        if (!ad.containsKey(updatePro)) {
            System.out.println("Product not found");
            return;
        }

        List<Object> temp = ad.get(updatePro);

        for (Object elem : temp) {
            if (elem instanceof Integer) {
                System.out.println("Current Count : " + elem);
            } else if (elem instanceof Double) {
                updatePrice = (Double) elem;
            }
        }

        System.out.print("Enter the Number of Products : ");
        updateCount = ip.nextInt();

        List<Object> newList = new ArrayList<>();
        newList.add(updateCount);
        newList.add(updatePrice);

        ad.put(updatePro, newList);
    }

    Double total = 0.0;

    void conform() {
        total = 0.0;
        int counts;

        System.out.println("Offer");
        System.out.println("Buy 2 get 1 free for a specific product.");
        System.out.println("Flat 10% off if total > 2000.");

        for (List<Object> values : ad.values()) {
            int c = 0;
            double p = 0;

            for (Object elem : values) {
                if (elem instanceof Integer) {
                    c = (Integer) elem;
                } else if (elem instanceof Double) {
                    p = (Double) elem;
                }
            }
            total += c * p;
        }

        System.out.printf("%-15s : %.2f\n", "Total", total);

        counts = ad.size();

        if (total >= 2000 && counts < 2) {
            System.out.printf("%-15s : %.2f\n", "Discount", total * 0.10);
            total -= total * 0.10;
        } else if (counts > 2) {
            total -= total * 0.05;
        } else {
            System.out.printf("%-15s : %d\n", "Discount", 0);
        }

        System.out.println("Total Amount After Discount : " + total);
        System.out.println();
    }
}

public class ShoppingCart {

    public static void main(String[] args) {
        int choice;
        try (Scanner inp = new Scanner(System.in)) {
            Cart ct = new Cart(inp);
            while (true) {
                System.out.println("Welcome to Dump Shopping Cart...");
                System.out.println("1.Add Items\n2.Update Cart\n3.Confirm the Order\n4.Clear the Cart\n5.Exit\n");
                System.out.print("Enter Your Choice : ");
                choice = inp.nextInt();
                switch (choice) {
                    case 1 -> {
                        ct.adding();
                    }
                    case 2 -> {
                        ct.update();
                    }
                    case 3 -> {
                        ct.conform();
                    }
                    case 4 -> {
                        ct.empty();
                    }
                    case 5 -> {
                        return;
                    }
                }
            }
        }
    }
}
