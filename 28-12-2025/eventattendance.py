"""
You’re managing sign-ups for tech workshops (like quantum computing or AI meetups!).
You have a list of attendee dictionaries:


attendees = [
    {"name": "Lena", "workshop": "Quantum Intro", "paid": True},
    {"name": "Tom", "workshop": "AI Basics", "paid": False},
    {"name": "Maya", "workshop": "Quantum Intro", "paid": True},
    {"name": "Raj", "workshop": "AI Basics", "paid": True}
]
Task:
Write a function count_paid_attendees(attendees, workshop_name) that returns the number of people who paid for a specific workshop.

"""
class Event:
    def __init__(self,attendees,store):
        self.attendance=attendees
        self.store=store

    def count(self):
                
        for co in self.attendance:
            if co["paid"]:
                workshop = co["workshop"]
                if workshop in self.store:
                    self.store[workshop] += 1
                else:
                    self.store[workshop] = 1        

attendees = [
    {"name": "Lena", "workshop": "Quantum Intro", "paid": True},
    {"name": "Tom", "workshop": "AI Basics", "paid": False},
    {"name": "Maya", "workshop": "Quantum Intro", "paid": True},
    {"name": "Raj", "workshop": "AI Basics", "paid": True}
]

store={}
event=Event(attendees,store)
event.count()

max_len = max(len(name) for name in store.keys())
for shop, co in store.items():
    print(f"{shop.ljust(max_len)} : {co}")


        