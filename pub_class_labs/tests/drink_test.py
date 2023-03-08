import unittest
from src.drink import Drink

class TestDrink(unittest.TestCase):

    def setUp(self):
        self.drink = Drink("Whiskey", 6.00)

    def test_drink_has_names(self):
        self.assertEqual("Whiskey", self.drink.name)

    def test_drink_has_price(self):
        self.assertEqual(6.00, self.drink.price)