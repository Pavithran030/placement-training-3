"""

    Scenario: Smart Thermostat Scheduler
        You’re programming a smart thermostat that adjusts temperature based on time of day.
        The thermostat follows a simple schedule with three modes:

        Morning (6 AM – 11:59 AM) → Target: 22°C
        Day (12 PM – 5:59 PM) → Target: 20°C (energy saving)
        Night (6 PM – 5:59 AM) → Target: 18°C
        You’re given the current hour (in 24-hour format, as an integer from 0 to 23).

    🎯 Your Task
            Write a function get_target_temp(current_hour) that:

            Takes the current hour (e.g., 9 for 9 AM, 18 for 6 PM)
            Returns the correct target temperature as an integer (22, 20, or 18)
            Handles all 24 hours correctly

        ⏰ Note:

            6 AM = hour 6
            12 PM (noon) = hour 12
            6 PM = hour 18
            Midnight = hour 0

"""

class SmartThermostat:

    def __init__(self, current_hour):
        self.current_hour = current_hour

    def get_target_temp(self):
        if 6 <= self.current_hour < 12:
            return 22
        elif 12 <= self.current_hour < 18:
            return 20
        else:
            return 18   
        
thermostat = SmartThermostat(9) 
target_temp = thermostat.get_target_temp()     
print("Target temperature:", target_temp, "°C")
