/*

    Attendance File Merger

    Given two lists of student IDs representing attendance for two different days, merge them to find:

    Students present both days.

        Only on Day 1.

        Only on Day 2.

    Use Set operations to produce these lists and print them.

 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AttendanceMerge {

    public static Set<String> readFromFile(String filename) {
        Set<String> students = new HashSet<String>();
        BufferedReader file = null;

        try {
            file = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = file.readLine()) != null) {
                line = line.trim();
                if (!line.equals("")) {
                    students.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot read file: " + filename);
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
            }
        }

        return students;
    }

    public static void main(String[] args) {
        Set<String> day1 = readFromFile("day1_attendance.txt");
        Set<String> day2 = readFromFile("day2_attendance.txt");

        if (day1.isEmpty() || day2.isEmpty()) {
            System.out.println("One file is missing or empty.");
            return;
        }

        Set<String> both = new HashSet<String>(day1);
        both.retainAll(day2);

        Set<String> only1 = new HashSet<String>(day1);
        only1.removeAll(day2);

        Set<String> only2 = new HashSet<String>(day2);
        only2.removeAll(day1);

        ArrayList<String> listBoth = new ArrayList<String>(both);
        ArrayList<String> listOnly1 = new ArrayList<String>(only1);
        ArrayList<String> listOnly2 = new ArrayList<String>(only2);

        Collections.sort(listBoth);
        Collections.sort(listOnly1);
        Collections.sort(listOnly2);

        System.out.println("Present on both days: " + listBoth);
        System.out.println("--------------------------------------");
        System.out.println("Only on day 1: " + listOnly1);
        System.out.println("Only on day 2: " + listOnly2);
        System.out.println("--------------------------------------");
    }
}
