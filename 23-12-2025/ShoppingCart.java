
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

// class Cart {
//     Scanner ip;
//     String product;
//     int count;
//     Double price;
//     public Cart(Scanner ip) {
//         this.ip = ip;
//     }
//     Map<String, List<Object>> ad = new HashMap<>();
//     List<Object> productDetails = new ArrayList<>();
//     void adding() {
//         System.out.print("Enter the Product Name :");
//         product = ip.next();
//         // System.out.println();
//         System.out.print("Enter the No.of Count : ");
//         count = ip.nextInt();
//         System.out.print("Enter the Price of the Product : ");
//         price = ip.nextDouble();
//         System.out.println();
//         productDetails.add(count);
//         productDetails.add(price);
//         ad.put(product, productDetails);
//     }
//     String updatePro;
//     int updateCount;
//     Double updatePrice;
//     void update() {
//         System.out.print("Enter the Product Name : ");
//         updatePro = ip.next();
//         List<Object> temp = ad.get(updatePro);
//         for (Object elem : temp) {
//             if (elem instanceof Integer) {
//                 System.out.println("Current Count : " + elem);
//             } else if (elem instanceof Double) {
//                 updatePrice = (Double) elem;
//             }
//         }
//         System.out.println("Enter the Number of Products : ");
//         updateCount = ip.nextInt();
//         List<Object> newList = new ArrayList<>();
//         newList.add(updateCount, updatePrice);
//         ad.put(product, newList);
//     }
//     Double total = 0.0;
//     void conform() {
//         int counts;
//         System.out.println("Offer\nBuy 2 get 1 free for a specific product.");
//         System.out.println("Flat 10% off if total > 2000.");
//         if (updatePro != null) {
//             List<Object> temp1 = ad.get(updatePro);
//             for (Object elem : temp1) {
//                 if (elem instanceof Double d) {
//                     total += d;
//                 }
//             }
//         } else {
//             List<Object> temp2 = ad.get(productDetails);
//             for (Object elem : temp2) {
//                 if (elem instanceof Double d) {
//                     total += d;
//                 }
//             }
//             System.out.printf("%-15 : %.2f\n", "Total", total);
//             counts = ad.size();
//             if (total >= 2000 && counts < 2) {
//                 System.out.printf("%-15 : %.2f\n ", "Discount : ", total * (10 / 100));
//                 total -= (total * (10 / 100));
//             } else if (counts > 2) {
//                 total -= (total * (5 / 100));
//             } else {
//                 System.out.printf("%-15 : %-10d\n", "Discount : ", 0);
//             }
//             System.out.println("Total Amount After Discount : " + total);
//             System.out.println();
//         }
//     }
//     public class ShoppingCart {
//         public static void main(String[] args) {
//             int choice;
//             try (Scanner inp = new Scanner(System.in)) {
//                 Cart ct = new Cart(inp);
//                 while (true) {
//                     System.out.println("Welcome to Dump Shopping Cart...");
//                     System.out.println("1.Add Items\n2.Update Cart\n3.Confirm the Order\n4.Exit\n");
//                     System.out.print("Enter Your Choice : ");
//                     choice = inp.nextInt();
//                     switch (choice) {
//                         case 1 -> {
//                             ct.adding();
//                         }
//                         case 2 -> {
//                             ct.update();
//                         }
//                         case 3 -> {
//                             ct.conform();
//                         }
//                         case 4 -> {
//                             return;
//                         }
//                     }
//                 }
//             }
//         }
//     }
// }
class Product {

    int quantity;
    double price;

    Product(int q, double p) {
        quantity = q;
        price = p;
    }
}

class Cart {

    Scanner ip;
    Map<String, Product> ad = new HashMap<>();

    public Cart(Scanner ip) {
        this.ip = ip;
    }

    void adding() {
        System.out.print("Enter Product: ");
        String name = ip.next();
        System.out.print("Count: ");
        int qty = ip.nextInt();
        System.out.print("Price: ");
        double price = ip.nextDouble();
        ad.put(name, new Product(qty, price));
    }

    void update() {
        System.out.print("Product to update: ");
        String name = ip.next();
        if (!ad.containsKey(name)) {
            System.out.println("Not found!");
            return;
        }
        System.out.print("New count: ");
        int newQty = ip.nextInt();
        Product p = ad.get(name);
        ad.put(name, new Product(newQty, p.price));
    }

    void conform() {
        double total = 0;
        for (Product p : ad.values()) {
            total += p.quantity * p.price;
        }

        System.out.printf("Total: %.2f%n", total);
        double discount = 0;
        if (total > 2000) {
            discount = total * 0.10;
        } else if (ad.size() >= 3) {
            discount = total * 0.05;
        }
        System.out.printf("Discount: %.2f%n", discount);
        System.out.printf("Final: %.2f%n", total - discount);
    }
}

class ShoppingCart {

    public static void main(String[] args) {
        try (Scanner inp = new Scanner(System.in)) {
            Cart ct = new Cart(inp);
            // ... menu loop
            int choice;
            while (true) {
                System.out.println("Welcome to Dump Shopping Cart...");
                System.out.println("1.Add Items\n2.Update Cart\n3.Confirm the Order\n4.Exit\n");
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
                        return;
                    }
                }
            }
        }

    }
}
