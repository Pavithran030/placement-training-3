"""

Scenario: Package Delivery Grid
    You’re programming a delivery drone that operates on a 3x3 city grid (like a mini downtown).
    Each cell in the grid is identified by a row and column (0 to 2 for both).

You’re given:

    The drone’s current position as (row, col)
    Example: (1, 2) → middle row, rightmost column
    A list of blocked cells (under construction)
    Example: [(0, 1), (2, 2)]
    🚧 The drone cannot move into blocked cells.

🎯 Your Task
    Write a function get_valid_moves(current_pos, blocked) that:

    Returns a list of all valid adjacent positions the drone can move to in one step
    Valid moves: up, down, left, right (no diagonals)
    Must stay within the 3x3 grid (0 ≤ row ≤ 2, 0 ≤ col ≤ 2)
    Must not be in the blocked list

"""

class PackageDeliveryDrone:

    def __init__(self, current_pos, blocked):
        self.current_pos = current_pos
        self.blocked = blocked

    def get_valid_moves(self):
        row, col = self.current_pos
        potential_moves = [
            (row - 1, col),  
            (row + 1, col),  
            (row, col - 1),  
            (row, col + 1)
        ]
        
        valid_moves = []
        for r, c in potential_moves:
            if 0 <= r <= 2 and 0 <= c <= 2 and (r, c) not in self.blocked:
                valid_moves.append((r, c))
        
        return valid_moves

drone = PackageDeliveryDrone((1, 2), [(0, 1), (2, 2)])
moves = drone.get_valid_moves()
print(moves)  