/*

    Create a simple program that:

        Lets you add text (like typing at the end).
        Lets you undo the last thing you did.
        Lets you redo if you undo too much.
        Remember up to 1,000 actions.
    We’ll use ArrayList (you already know it from Collections!) to store the history.

 */

import java.util.*;

class RedoUndo {

    String currenttext = "";
    // String disp = "";

    ArrayList<String> history = new ArrayList<>();
    ArrayList<String> redolist = new ArrayList<>();
    final int MAX_SIZE = 1000;

    public void type(String types) {
        history.add(types);

        if (history.size() > MAX_SIZE) {
            history.remove(0);
        }
        redolist.clear();
        currenttext += types;
        print();
        // disp += currenttext;
    }

    public void undo() {
        if (history.isEmpty()) {
            System.out.println("Nothing to Undo....");
            return;
        }
        redolist.add(currenttext);

        currenttext = history.remove(history.size() - 1);
        System.out.println("Undo Done..Current word : " + currenttext);
        print();

    }

    public void redo() {
        if (redolist.isEmpty()) {
            System.out.println("Nothing to Redo....");
            return;
        }

        history.add(currenttext);
        currenttext = redolist.remove(redolist.size() - 1);
        System.out.println("Redo Done..Current word : " + currenttext);
        print();

    }

    public void print() {
        for (String s : history) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}

public class TextEditor {

    public static void main(String[] args) {
        RedoUndo pro = new RedoUndo();

        try (Scanner inp = new Scanner(System.in)) {
            System.out.println("Simple Text Editor\n-----------------------------------------");
            while (true) {
                String st;
                System.out.println("\n1.Add Text\n2.Undo Text\n3.Redo Text\n4.Exit\n");
                System.out.print("Enter Your Choice : ");
                int choice = inp.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("Type ur input text : ");
                        st = inp.next();
                        pro.type(st);

                    }
                    case 2 -> {
                        pro.undo();

                    }
                    case 3 -> {
                        pro.redo();
                    }
                    case 4 -> {
                        return;
                    }

                    default ->
                        System.out.println("Invalid Choice....");
                }

            }

        }
    }

}
