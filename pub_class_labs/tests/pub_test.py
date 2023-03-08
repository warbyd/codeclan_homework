import unittest
from src.pub import Pub 

class TestPub(unittest.TestCase):

    def setUp(self):
        self.pub = Pub("Geri's Pub", 100.00)

    def test_pub_has_name(self):
        self.assertEqual("Geri's Pub", self.pub.name)

    def test_can_increase_till(self):
        self.pub.increase_till(5.00)
        self.assertEqual(105.00, self.pub.till)

    def test_can_check_price(self):
        price = self.pub.check_price("Beer")
        self.assertEqual(4.00, price)

    