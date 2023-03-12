import unittest
from classes.guest import Guest
from classes.song import Song
from classes.room import Room
from classes.karaoke_bar import KaraokeBar

class TestRoom(unittest.TestCase):

    def setUp(self):
        self.room = Room("Room 1", 5, 30.00,)
        self.songs = [Song("All Star", "Smash Mouth"),
                      Song("Purple Rain", "Prince"),
                      Song("Don't Stop Believin", "Journey"),
                      Song("Bohemian Rhapsody", "Queen"),
                      Song("Rehab", "Amy Winehouse")]
        self.guest1 = Guest("Dale", 500, [self.songs[1]])
        self.guest2 = Guest("Bob", 300, [self.songs[0]])
        self.room.add_guest(self.guest1)
        self.room.add_guest(self.guest2)
        self.room.playlist.append(self.songs[2])
        self.room.add_guest(self.guest1)
        self.room.add_guest(self.guest2)
        
        

    def test_play_song(self):
        self.assertEqual(self.room.playlist[0], self.songs[2])

    def test_stop_play_song(self):
        if self.room.current_song in self.room.playlist:
            self.room.stop_song()
            self.assertIsNone(self.room.current_song)

    def test_add_guest(self):
        guest1 = Guest("Dale", 100, [self.songs[1]])
        self.room.add_guest(guest1)
        self.assertIn(self.guest1, self.room.guests)

    def test_has_capacity_for_guest(self):
        guest = Guest("Dale", 100, [self.songs[1]])
        self.assertTrue(self.room.has_capacity())
        self.room.add_guest(guest)
        self.assertEqual(len(self.room.guests), self.room.capacity)



    

