/*

    Enum-Based Role Permission System
        Concept: enum with methods, encapsulation, and security logic

        You’re building a system where users have roles: GUEST, USER, ADMIN.
    Each role has different permissions:

        GUEST: can only view
        USER: can view and edit
        ADMIN: can view, edit, and delete
    Task:
        Create an enum Role where each constant defines its allowed actions.
        Write a method boolean canPerform(Role role, String action) that returns true if the role can do that action.

        ✅ Skills: enums with behavior, clean permission modeling
        ✅ Why new?: First time using enums with custom logic per constant

 */

enum Role {
    GUEST,
    USER,
    ADMIN;

    public boolean canPerform(String action) {
        return switch (this) {
            case GUEST ->
                action.equals("view");
            case USER ->
                action.equals("view") || action.equals("edit");
            case ADMIN ->
                action.equals("view") || action.equals("edit") || action.equals("delete");
        };
    }
}

public class Permission {

    public static boolean canPerform(Role role, String action) {
        if (role == null || action == null) {
            return false;
        }
        return role.canPerform(action);
    }

    public static void main(String[] args) {
        System.out.println(canPerform(Role.GUEST, "view"));
        System.out.println(canPerform(Role.GUEST, "edit"));
        System.out.println(canPerform(Role.USER, "edit"));
        System.out.println(canPerform(Role.ADMIN, "delete"));
        System.out.println(canPerform(Role.ADMIN, "fly"));
    }
}
