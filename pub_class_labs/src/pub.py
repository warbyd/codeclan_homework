
from src.drink import Drink

class Pub:
    def __init__(self, name, till):
        self.drinks = [Drink("Whiskey", 6.00), Drink("Beer", 4.00), Drink("Wine", 10.00)]
        self.name = name
        self.till = till

    def increase_till(self, amount):
        self.till += amount
    
    def check_price(self, name_drink):
        for drink in self.drinks:
            if drink.name == name_drink:
                return drink.price
            
    def purchase(self, drink_name, customer):
    
        customer.wallet -= self.check_price(drink_name)
        self.increase_till(self.check_price(drink_name))