"""
    Scenario: Sensor Data Stream Analyzer

        You’re monitoring a temperature sensor that sends data as a continuous stream of numbers (simulated as a string).
        Each reading is separated by a comma, but the stream may contain invalid values like "error", "--", or empty entries.

    Example stream:
        "23.5,24.1,error,22.8,,25.0,--,24.7"

    Your job is to process this stream in real time and:

        Skip invalid entries
        Keep only valid float temperatures
        Return the average of the last 3 valid readings

    🎯 Your Task
        Write a function latest_avg(stream) that:

            Takes a string like "23.5,24.1,error,22.8,,25.0,--,24.7"
            Extracts all valid floats (ignore anything that isn’t a number)
            Keeps only the last 3 valid values
            Returns their average as a float, rounded to 1 decimal place
            If fewer than 3 valid values exist, average what’s available
            If no valid values, return None

"""

class Signal:
    
    def latest_avg(self,signal):
        lst=[signal.split(",")]
        re=[]
        if not signal.strip():    
            return "No signal data provided"
        
        for i in lst:
            if i!="--" and i!="error" and i!="":
                re.append(float(i))

        if not re:        
            return "No valid signal values found"
        
        if not lst:
            return False    
        
        si=len(re)
        avg=0.0
        if si<=3:
            avg=sum(re)/si
        else:
            temp=0
            for j in re:
                temp+=float(j)
            avg=temp/si
        return avg


sig=input("Enter the Signal : ")
sc=Signal()
print(sc.latest_avg(sig))