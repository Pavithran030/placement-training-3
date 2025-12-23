/*

    Vehicle Rental System

    Base class Vehicle with fields regNo, brand, baseRatePerDay.

    Subclasses: Car, Bike, Truck with additional fields (e.g., seats, hasAC, loadCapacity).

    Method calculateRent(int days) overridden in each subclass with different logic (e.g., cars include AC surcharge, trucks include load surcharge).

    Use an interface Maintainable with method scheduleService() implemented differently across vehicle types.

    In main, show rent calculation for various vehicles using only Vehicle references

 */

import java.util.*;

class Vehicle {

    void available() {
        System.out.println("1.Bike\n2.Car\n3.Truck");
    }

    int calculateRent(int days, int ops) {
        if (ops == 1) {
            return 150 * days;
        } else {
            return 100 * days;
        }
    }
}

class Car extends Vehicle {

    Scanner sc;

    public Car(Scanner sc) {
        this.sc = sc;
    }

    double types(int ch, double value, int days) {
        if (ch == 1) {
            return 80 * days;
        } else if (ch == 2) {
            System.out.print("Car with AC (choose 1) or Non_AC (choose 0) : ");
            int op = sc.nextInt();
            return calculateRent(days, op);
        } else {
            return value * 200 * days;
        }
    }
}

public class Vehicle_Rental {

    public static void main(String[] args) {
        try (Scanner inp = new Scanner(System.in)) {

            Car ve = new Car(inp);

            while (true) {
                System.out.println("Welcome to Vehicle Rental System\n");
                System.out.println("---------------------------------------------------------------------\n");
                System.out.print("1.Available Vehicles\n2.Book the Vehicle\n3.Exit\n\n");
                System.out.print("Choose the option to book the Vehicle...");
                int choice = inp.nextInt();
                System.out.println();

                switch (choice) {

                    case 1 ->
                        ve.available();

                    case 2 -> {
                        ve.available();
                        System.out.print("Enter Your Option to Choose the Vehicle : ");
                        int ch = inp.nextInt();
                        System.out.print("Enter the Number of Days : ");
                        int day = inp.nextInt();

                        double rent;

                        if (ch == 1) {
                            rent = ve.types(ch, 0, day);
                        } else if (ch == 2) {
                            System.out.print("Enter the Number of Members : ");
                            int members = inp.nextInt();
                            rent = ve.types(ch, members, day);
                        } else if (ch == 3) {
                            System.out.print("Enter the Load Weight (in Tons) : ");
                            double load = inp.nextDouble();
                            rent = ve.types(ch, load, day);
                        } else {
                            System.out.println("Invalid Vehicle Option");
                            continue;
                        }

                        System.out.println("Rental for your Vehicle : " + rent);
                        System.out.println();
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
