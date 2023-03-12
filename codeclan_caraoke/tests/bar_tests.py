import unittest
from classes.bar import Bar
from classes.drink import Drink
from classes.guest import Guest

class TestBar(unittest.TestCase):
    def setUp(self):
        self.bar = Bar("The Bar", 1000, [])
        self.drink_1 = Drink("Beer", 4.50, 2)
        self.drink_2 = Drink("Wine", 6.00, 3)
        self.drink_3 = Drink("Cider", 3.00, 0)
        self.guest_1 = Guest("James", 10.00, 28)
        self.guest_2 = Guest("Sarah", 20.00, 22)
        self.guest_3 = Guest("John", 5.00, 35)

    def test_bar_has_name(self):
        self.assertEqual("The Bar", self.bar.name)

    def test_bar_has_till(self):
        self.assertEqual(1000, self.bar.till)

    def test_bar_can_add_drinks_to_stock(self):
        self.bar.add_drink_to_stock(self.drink_1)
        self.bar.add_drink_to_stock(self.drink_2)
        self.assertEqual(2, len(self.bar.drinks))

    def test_bar_can_remove_drinks_from_stock(self):
        self.bar.add_drink_to_stock(self.drink_1)
        self.bar.add_drink_to_stock(self.drink_2)
        self.bar.remove_drink_from_stock(self.drink_1)
        self.assertEqual(1, len(self.bar.drinks))

    def test_bar_stock_level(self):
        self.bar.add_drink_to_stock(self.drink_1)
        self.bar.add_drink_to_stock(self.drink_2)
        self.assertEqual(1, self.bar.stock_level(self.drink_1))
        self.assertEqual(0, self.bar.stock_level(self.drink_3))

    def test_guest_can_buy_drink(self):
        self.bar.add_drink_to_stock(self.drink_1)
        self.assertTrue(self.bar.sell_drink(self.guest_1, self.drink_1))
        self.assertEqual(5.50, self.guest_1.wallet)
        self.assertEqual(1000, self.bar.till)
        self.assertEqual(0, self.bar.stock_level(self.drink_1))

    def test_guest_cannot_buy_drink_if_not_enough_money(self):
        self.bar.add_drink_to_stock(self.drink_1)
        self.assertTrue(self.bar.sell_drink(self.guest_3, self.drink_1))
        self.assertEqual(0.5, self.guest_3.wallet)
        self.assertEqual(1000, self.bar.till)
        self.assertEqual(0, self.bar.stock_level(self.drink_1))

    def test_guest_cannot_buy_drink_if_not_in_stock(self):
        self.assertFalse(self.bar.sell_drink(self.guest_2, self.drink_1))
        self.assertEqual(20.00, self.guest_2.wallet)
        self.assertEqual(1000, self.bar.till)
        self.assertEqual(0, self.bar.stock_level(self.drink_1))
