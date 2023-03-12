import unittest
from classes.guest import Guest
from classes.song import Song
from classes.karaoke_bar import KaraokeBar
from classes.drink import Drink

class TestKaraokeBar(unittest.TestCase):

    def setUp(self):
        self.karaoke_bar = KaraokeBar("The Karaoke Bar", 5000)
        

    def test_karaoke_bar_has_name(self):
        self.assertEqual("The Karaoke Bar", self.karaoke_bar.name)


    def test_karaoke_bar_has_till(self):
        self.assertEqual(5000, self.karaoke_bar.till)

    def test_karaoke_bar_charges_for_rooms(self):
        self.assertTrue(self.karaoke_bar.charge_entry_fee(self.room))
        self.assertEqual(70.00, self.guest.wallet)


