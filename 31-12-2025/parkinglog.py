"""
    Scenario: Smart Parking Lot Tracker
        You're developing a backend system for a smart parking app.
        Each time a car enters or exits the parking lot, a log entry is recorded with:

        car_id (a unique string like "ABC123")
        action ("enter" or "exit")
        timestamp (you can ignore this for now)
    You’re given a list of log entries:

    logs = [
        {"car_id": "XYZ789", "action": "enter"},
        {"car_id": "ABC123", "action": "enter"},
        {"car_id": "XYZ789", "action": "exit"},
        {"car_id": "DEF456", "action": "enter"},
        {"car_id": "ABC123", "action": "exit"},
        {"car_id": "ABC123", "action": "enter"},
    ]

    Write a function count_parked_cars(logs) that:

    Determines which cars are currently parked (based on their most recent action)
    Returns the total number of cars currently in the lot.

"""
class ParkingLotTracker:

    def __init__(self,logstore):
        self.logstore = logstore

    def count_parked_cars(self):
        parked_cars = set()
        for log in self.logstore:
            car_id = log["car_id"]
            action = log["action"]
            if action == "enter":
                parked_cars.add(car_id)
            elif action == "exit":
                parked_cars.discard(car_id)
        return len(parked_cars)



logs = [
        {"car_id": "XYZ789", "action": "enter"},
        {"car_id": "ABC123", "action": "enter"},
        {"car_id": "XYZ789", "action": "exit"},
        {"car_id": "DEF456", "action": "enter"},
        {"car_id": "ABC123", "action": "exit"},
        {"car_id": "ABC123", "action": "enter"},
    ]   


pa=ParkingLotTracker(logs)
count=pa.count_parked_cars()    
print("Total parked cars:",count)

