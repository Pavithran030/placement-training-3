"""
Café Order Validator
A café only accepts orders for at least 1 drink and 1 pastry.
Drinks: "coffee", "tea", "juice"
Pastries: "croissant", "muffin", "scone"

"""



class Cafe:
    def __init__(self,orders):
        self.orders=orders
        self.drinks={"coffee","tea","juice"}
        self.pastries={"croissant","muffin","scone"}

    def check(self):
        drink=False
        pastry=False
        for item in self.orders:
            if item in self.drinks:
                drink=True
            if item in self.pastries:
                pastry=True
        if drink and pastry:
            print("Order accepted") 
        else:
            print("Order rejected")



ord=input("Enter the items : ").split()
cafe=Cafe(ord)
cafe.check()