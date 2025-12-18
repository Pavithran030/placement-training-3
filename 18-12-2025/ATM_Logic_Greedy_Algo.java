
import java.util.*;

class ATM_Logic_Greedy_Algo {

    public static void main(String[] args) {
        try (Scanner inp = new Scanner(System.in)) {
            // int amount;
            System.out.print("Enter the Amount to withdrawl : ");
            int amount = inp.nextInt();

            if (amount < 100) {
                System.out.println("The Minimum Amount to Withdrawl is 100");
                return;
            }

            int[] money = {2000, 500, 200, 100};
            int[] notes = new int[4];

            int remaining = amount;

            for (int i = 0; i < money.length; i++) {
                notes[i] = remaining / money[i];
                remaining %= money[i];

            }
            System.out.println("2000 : " + notes[0] + "\n500 : " + notes[1] + "\n200 : " + notes[2] + "\n100 : " + notes[3]);

        }
    }
}
