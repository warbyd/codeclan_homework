import unittest
from src.customer import Customer

class TestCustomer(unittest.TestCase):

    def setUp(self):
        self.customer = Customer("Whatever Potter", 20.00)

    def test_customer_has_name(self):
        self.assertEqual("Whatever Potter", self.customer.name)

    def test_customer_wallet(self):
        self.assertEqual(20.00, self.customer.wallet)