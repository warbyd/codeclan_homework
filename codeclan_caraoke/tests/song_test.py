import unittest
from classes.song import Song
from classes.room import Room

class TestSong(unittest.TestCase):

    def setUp(self):
        self.songs = [
            Song("All Star", "Smash Mouth"),
            Song("Purple Rain", "Prince"),
            Song("Don't Stop Believin", "Journey"),
            Song("Bohemian Rhapsody", "Queen"),
            Song("Rehab", "Amy Winehouse"),
        ]

    def test_song_has_name(self):
        self.assertEqual(self.songs[0].title, "All Star")
        self.assertEqual(self.songs[0].artist, "Smash Mouth")
        self.assertEqual(self.songs[1].title, "Purple Rain")
        self.assertEqual(self.songs[1].artist, "Prince")
        self.assertEqual(self.songs[2].title, "Don't Stop Believin")
        self.assertEqual(self.songs[2].artist, "Journey")
        self.assertEqual(self.songs[3].title, "Bohemian Rhapsody")
        self.assertEqual(self.songs[3].artist, "Queen")
        self.assertEqual(self.songs[4].title, "Rehab")
        self.assertEqual(self.songs[4].artist, "Amy Winehouse")

