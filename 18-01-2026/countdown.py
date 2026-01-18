"""
    Concept: datetime module, time arithmetic, real-world time logic

        Given an event date string like "2026-06-15", calculate:

        Days until event
        If event passed → show “Event completed X days ago”
    Task:
        Write countdown(event_date_str) that returns a friendly message.

        ✅ Skills: Parsing dates, timedelta, conditional time messaging
        ✅ Why new?: First use of real calendar/time math

"""

from datetime import datetime, date

ds = "2026-06-15"  
try:
    dt = datetime.strptime(ds, "%Y-%m-%d").date()
except ValueError:
    print("Bad date! Use YYYY-MM-DD.")
else:
    td = date.today()
    dx = (dt - td).days
    
    if dx > 0:
        s = "" if dx == 1 else "s"
        print(f"Event in {dx} day{s}!")
    elif dx == 0:
        print("Event is today! 🎉")
    else:
        px = -dx
        s = "" if px == 1 else "s"
        print(f"Event was {px} day{s} ago.")