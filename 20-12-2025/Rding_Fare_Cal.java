/*
Ride-Sharing Fare Estimator

Create Ride class with fields: id, pickupLocation, dropLocation, distanceKm, vehicleType (AUTO, MINI, SEDAN).

Create a method calculateFare() that uses base fares and per-km rates depending on vehicle type (e.g., AUTO: base 30 + 10/km, MINI: 40 + 12/km, SEDAN: 60 + 15/km).

In main, read details for multiple rides and print a bill for each ride.

Add a discount method which applies 10% off if distanceKm > 15 or a promo code is entered.
 */

import java.util.*;

class Ride {

    int id;
    double distanceKm;
    String pickuplocation, droplocation, vehicleType, promocode;

    Ride(int id, String pickuplocation, String droplocation, String vehicleType, double distanceKm) {
        this.id = id;
        this.pickuplocation = pickuplocation;
        this.droplocation = droplocation;
        this.distanceKm = distanceKm;
        this.vehicleType = vehicleType;
    }

    double calculateFare(double dist, String Type) {
        double price = 0;

        if (vehicleType.equalsIgnoreCase("AUTO")) {
            price = dist * 10 + 30;
        } else if (vehicleType.equalsIgnoreCase("MINI")) {
            price = dist * 12 + 40;
        } else if (vehicleType.equalsIgnoreCase("SEDAN")) {
            price = dist * 15 + 60;
        }

        return price;
    }

    double discount(String promocode) {
        double dis = calculateFare(this.distanceKm, this.vehicleType);

        if (distanceKm > 15 || promocode != null) {
            return dis *= 0.9;
        }
        return dis;

    }

}

public class Rding_Fare_Cal {

    public static void main(String[] args) {
        try (Scanner inp = new Scanner(System.in)) {
            // Ride ri=new Ride();
            // while (true) {
            //     System.out.print("Enter ID : ");
            //     int ids = inp.nextInt();
            //     System.out.print("Enter pickuplocation : ");
            //     String pick = inp.next();
            //     System.out.print("Enter droplocation : ");
            //     String drop = inp.next();
            //     System.out.print("Enter the distance : ");
            //     int dis = inp.nextInt();
            //     System.out.print("Enter the Vehicle type (AUTO, MINI, SEDAN) : ");
            //     String vehicle = inp.next();
            //     System.out.print("Enter Promocode (if available) : ");
            //     String promo = inp.next();

            //     Ride ri = new Ride(ids, pick, drop, vehicle, dis);
            //     System.out.println("The Charge for ur Travel Through " + vehicle + "is : " + ri.discount(promo));
            // }
            System.out.print("Enter ID : ");
            int ids = inp.nextInt();
            System.out.print("Enter pickuplocation : ");
            String pick = inp.next();
            System.out.print("Enter droplocation : ");
            String drop = inp.next();
            System.out.print("Enter the distance : ");
            int dis = inp.nextInt();
            System.out.print("Enter the Vehicle type (AUTO, MINI, SEDAN) : ");
            String vehicle = inp.next();
            System.out.print("Enter Promocode (if available) : ");
            String promo = inp.next();

            Ride ri = new Ride(ids, pick, drop, vehicle, dis);

            System.out.println("The Charge for ur Travel Through " + vehicle + "is : " + ri.discount(promo));

        }
    }

}
