"""

    Concept: Functions as first-class objects, list of dicts, scoring rules

        You have a quiz with questions of different types:

        "mcq": multiple choice → full points if correct
        "short": short answer → partial credit possible

    Task:
        Write grade_quiz(questions, answers) where answers is a list like ["B", "Paris"].
        Return total score.

        ✅ Skills: Flexible data-driven logic, no hardcoded rules
        ✅ Why new?: Emphasizes adaptable grading, not just counting

"""

qs = [
    {"t": "mcq", "c": "B", "p": 5},
    {"t": "short", "c": "Paris", "p": 10},
    {"t": "mcq", "c": "A", "p": 5}
]

ans = ["B", "I think it's Paris!", "C"]

sc = 0

for i in range(len(qs)):
    q = qs[i]
    a = ans[i]
    ok = q["c"]
    pt = q["p"]
    tp = q["t"]
    
    if tp == "mcq":
        if a == ok:
            sc += pt
            
    elif tp == "short":
        if isinstance(a, str) and isinstance(ok, str):
            if ok.lower() in a.lower():
                sc += pt

print("Score:", sc)