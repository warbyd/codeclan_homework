import unittest
from classes.guest import Guest
from classes.song import Song
from classes.room import Room

class TestGuest(unittest.TestCase):

    def setUp(self):
        self.room = ("Room 1")
        self.guest = Guest("Dale", 100.00, "Purple Rain",)
        self.song = Song("Purple Rain", "Prince")
        self.guest.set_favourite_song(self.song)
       


    def test_guest_has_name(self):
        self.assertEqual("Dale", self.guest.name)

    def test_guest_has_wallet(self):
        self.assertEqual(100.00, self.guest.wallet)

    def test_guest_can_afford_room(self):
        room = Room("Room 1", 5, 30.00)
        self.assertEqual(True, self.guest.can_afford_room(room))

    def test_cheer_if_favourite_song_is_on(self):
        output = self.guest.cheer_if_favourite_song("Purple Rain")
        self.assertEqual("Whoo!", output)

    