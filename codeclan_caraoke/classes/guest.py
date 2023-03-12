class Guest:

    def __init__(self, name, wallet, favourite_song):
        self.name = name
        self.wallet = wallet
        self.favourite_song = favourite_song
        self.drunkenness = 0

    def buy_drink(self, drink):
        if self.sufficient_funds(drink.price):
            self.wallet -= drink.price
            self.drunkenness += drink.alcohol_level

    def set_favourite_song(self, song):
        self.favourite_song = song.title

    def can_afford_room(self, room):
        return self.wallet >= room.entry_fee
    
    def buy_room(self, room):
        if self.can_afford_room(room):
            self.pay(room.entry_fee)
            room.add_guest(self)
            return True
        else:
            return False

    def pay(self, amount):
        self.wallet -= amount
        
    def cheer_if_favourite_song(self, song_title):
        if song_title == self.favourite_song:
            return "Whoo!"

    def can_afford(self, amount):
        return self.wallet >= amount

    def sufficient_funds(self, price):
        return self.wallet >= price
   