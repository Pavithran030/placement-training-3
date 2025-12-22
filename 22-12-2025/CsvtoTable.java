/*

    CSV to Table Formatter

    Input lines like: id,name,salary then 101,John,45000 etc.

    Read the CSV and print data as a neatly aligned table (columns aligned).

    Compute and print the total salary and average salary.

    Handle trimming of spaces and ignore empty lines.

 */

import java.util.*;

public class CsvtoTable {

    public static void main(String[] args) {
        try (Scanner inp = new Scanner(System.in)) {

            ArrayList<String> ar = new ArrayList<>();

            String tx;
            int ch;
            System.out.print("Enter the Number of Member in the Office : ");
            ch = inp.nextInt();
            System.out.println("Format of Input : id,name,salary then 101,John,45000");
            for (int i = 0; i < ch; i++) {
                tx = inp.next();
                ar.add(tx);
            }
            Double salary = 0.0;
            System.out.printf("%-5s %-20s %-10s %n", "ID", "Name", "Salary");
            System.out.print("\n---------------------------------------------------------------\n");
            for (String sh : ar) {
                String[] str = new String[3];
                str = sh.split(",");
                salary += Double.parseDouble(str[2].trim());
                System.out.printf("%-5s %-20s %-10.2f%n", str[0].trim(), str[1].trim(), Double.parseDouble(str[2].trim()));
            }
            System.out.print("\n---------------------------------------------------------------\n");
            System.out.printf("%35.2f%n", salary);

        }
    }
}
