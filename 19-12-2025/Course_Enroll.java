
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*

Online Course Enrollment System

    Create a Course class with: courseId, name, maxStudents, enrolledCount.

    Create a Student class with: studentId, name.

    A CourseManager class manages enrollments using an array or list of Course and Student.

    Support operations:

    Add course, add student.

    Enroll a student in a course if capacity is not exceeded.

    Print list of students for a course and courses for a student (you can use a simple mapping like int[][] or additional classes).
 */
class Course {

    int maxStudents = 30, enrollCounts = 0;
    String courseName;

    int[] ava = new int[7];

    void display() {

        System.out.printf("%-8s %-45s %s%n", "courseID", "courseName", "Available Slots (outof 30");
        System.out.println("--------------------------------------------------------------------------");

        System.out.printf("%-8s %-45s %d%n", "1001", "AI-Fundamentals", 30 - ava[0]);
        System.out.printf("%-8s %-45s %d%n", "1002", "Prompt Engineering", 30 - ava[1]);
        System.out.printf("%-8s %-45s %d%n", "1003", "Quantum Computing for Everyone", 30 - ava[2]);
        System.out.printf("%-8s %-45s %d%n", "1004", "Quantum Machine Learning", 30 - ava[3]);
        System.out.printf("%-8s %-45s %d%n", "1005", "AI For Everyone", 30 - ava[4]);
        System.out.printf("%-8s %-45s %d%n", "1006", "Machine Learning", 30 - ava[5]);
        System.out.printf("%-8s %-45s %d%n", "1007", "Deep Learning Specialization", 30 - ava[6]);
    }

}

class Student {

    int courseID;
    String studentName;

    HashMap<Integer, ArrayList<String>> record = new HashMap<>();

}

public class Course_Enroll {

    public static void main(String[] args) {

        Student st = new Student();
        Course cr = new Course();
        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.println("\n1.Course Details\n2.To enroll the course....\n3.Exit");

            int choice = inp.nextInt();
            switch (choice) {
                case 1 -> {
                    cr.display();
                }
                case 2 -> {
                    System.out.print("Enter CourseID : ");
                    st.courseID = inp.nextInt();
                    inp.nextLine();
                    System.out.print("Enter Your Name : ");
                    st.studentName = inp.nextLine();
                    ArrayList<String> students = new ArrayList<>();
                    students.add(st.studentName);
                    st.record.put(st.courseID, students);
                    if (cr.ava[st.courseID % 10] < 30) {
                        cr.ava[st.courseID % 10]++;
                    }
                    if (cr.ava[st.courseID % 10] <= 0) {
                        System.out.println("The Maximum Slot is Reached,You cant able to enroll this Course....");
                    } else {
                        System.out.println("You have Successfully Enrolled this Course....");
                    }
                    // System.out.println(st.record);

                }
                case 3 -> {
                    return;
                }

                default ->
                    throw new AssertionError();
            }

        }

    }

}
