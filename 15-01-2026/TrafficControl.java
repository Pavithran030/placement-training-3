/*

    🧩 Scenario: Smart Traffic Light Controller

        You’re programming a traffic light system that cycles through states:
        🔴 RED → 🟢 GREEN → 🟡 YELLOW → back to 🔴 RED

    But instead of using strings like "red" or integers like 0, you’ll use an enum to represent each state—making your code safe, readable, and bug-resistant.

    ✅ Why enums?

        Prevent invalid states ("purp1e" won’t compile!)
        Enable IDE auto-completion
        Work seamlessly with switch

    🎯 Your Task
        Create an enum TrafficLight with values: RED, GREEN, YELLOW
        Write a method nextState(TrafficLight current) that returns the next state in the cycle
        Use a modern switch expression (Java 14+) for clean, concise logic
        🔄 Cycle:
        RED → GREEN
        GREEN → YELLOW
        YELLOW → RED

 */

enum TrafficLight {
    RED, YELLOW, GREEN
}

class Light {

    TrafficLight state(TrafficLight current) {
        return switch (current) {
            case RED ->
                TrafficLight.YELLOW;
            case YELLOW ->
                TrafficLight.GREEN;
            case GREEN ->
                TrafficLight.RED;
        };
    }
}

public class TrafficControl {

    public static void main(String[] args) {
        Light li = new Light();
        System.out.println("After RED: " + li.state(TrafficLight.RED));
        System.out.println("After GREEN: " + li.state(TrafficLight.GREEN));
        System.out.println("After YELLOW: " + li.state(TrafficLight.YELLOW));
    }

}
