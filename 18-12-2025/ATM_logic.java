// The ATM Logic: Write a program that takes an amount and calculates the minimum number of notes ($2000, 500, 200, 100$) required to fulfill the withdrawal.

import java.util.*;

class ATM_logic {

    @SuppressWarnings("UnusedAssignment")
    public static void main(String[] args) {
        try (Scanner inp = new Scanner(System.in)) {
            // int amount;
            System.out.print("Enter the Amount to withdrawl : ");
            int amount = inp.nextInt();

            // int[] ava = {2000, 500, 200, 100};
            int co2000 = 0, co500 = 0, co200 = 0, co100 = 0, remaining = amount;

            if (amount < 100) {
                System.out.println("The Minimum Amount to Withdrawl is 100");
            }

            if (remaining >= 2000) {
                co2000 = remaining / 2000;
                remaining %= 2000;
            }

            if (remaining >= 500) {
                co500 = remaining / 500;
                remaining %= 500;
            }

            if (remaining >= 200) {
                co200 = remaining / 200;
                remaining %= 200;
            }

            if (remaining >= 100) {
                co100 = remaining / 100;
                remaining %= 100;
            }

            System.out.println("2000 : " + co2000 + "\n500 : " + co500 + "\n200 : " + co200 + "\n100 : " + co100);

        }
    }
}
