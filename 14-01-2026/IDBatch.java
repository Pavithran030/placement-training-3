/*

    Scenario: Student ID Batch Validator
        You're building a system for a school that processes a list of student ID strings submitted via a web form.
        Each ID must follow strict rules:

    ✅ Valid ID Format:

        Exactly 7 characters long
        First 2 characters: uppercase letters (A–Z)
        Next 5 characters: digits only (0–9)
        Examples: "AB12345" → ✅ valid
        "Ab12345" → ❌ invalid (lowercase 'b')
        "A123456" → ❌ invalid (only 1 letter)
        "AB1234" → ❌ too short

    You’re given a List<String> of raw ID submissions (may include null, empty strings, or malformed entries).

    🎯 Your Task
        Create a Java class with a method that:

            Takes a List<String> rawIds
            Returns a new list containing only the valid IDs, in the same order
            Skips invalid, null, or malformed entries without crashing

            💡 Use defensive programming—assume input is messy!

 */

import java.util.*;

class Validator {

    List<String> check(List<String> raw) {
        if (raw == null) {
            return new ArrayList<>();
        }
        List<String> validID = new ArrayList<>();
        for (String id : raw) {
            if (isValidID(id)) {
                validID.add(id);
            }
        }
        return validID;
    }

    boolean isValidID(String id) {

        if (id == null || id.length() != 7) {
            return false;
        }

        for (int i = 0; i < 2; i++) {
            if (!Character.isUpperCase(id.charAt(i))) {
                return false;
            }
        }

        for (int i = 2; i < 7; i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

class IDBatch {

    public static void main(String[] args) {

        Validator va=new   Validator();
        try (Scanner inp = new Scanner(System.in)) {
            String id;
            System.out.print("Enter ur ID Nmber : ");
            id = inp.next();
            List<String> rawids = Arrays.asList(id.split(","));
            // rawids.put();
            System.out.println(va.check(rawids));
        }

    }
}
