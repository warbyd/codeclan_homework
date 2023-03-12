class Bar:
    def __init__(self, name, till, drinks):
        self.name = name
        self.till = till
        self.drinks = {}

    def add_drink_to_stock(self, drink):
        if drink in self.drinks:
            self.drinks[drink] += 1
        else:
            self.drinks[drink] = 1

    def remove_drink_from_stock(self, drink, quantity=1):
        if drink in self.drinks:
            self.drinks[drink] -= quantity
            if self.drinks[drink] == 0:
                del self.drinks[drink]
            return True
        else:
            return False

    def stock_level(self, drink):
        if drink in self.drinks:
            return self.drinks[drink]
        else:
            return 0

    def sell_drink(self, guest, drink):
        if drink in self.drinks and self.drinks[drink] > 0 and guest.can_afford(drink.price):
            self.drinks[drink] -= 1
            guest.buy_drink(drink)
            return True
        else:
            return False