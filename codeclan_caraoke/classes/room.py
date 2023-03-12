from classes.guest import Guest
from classes.song import Song

class Room:
    def __init__(self, name, capacity, entry_fee):
        self.entry_fee = entry_fee
        self.name = name
        self.capacity = capacity
        self.guests = []
        self.playlist = []
        self.current_song = None
        self.playing = False

    def add_guest(self, guest):
        if self.has_capacity() and guest.can_afford_room(self):
            self.guests.append(guest)
            guest.pay(self.entry_fee)
            return True
        else:
            return False

    def remove_guest(self, guest):
        if guest in self.guests:
            self.guests.remove(guest)
        
    def has_guests(self):
        return len(self.guests) > 0
    
    def play_song(self, song):
        self.current_song = song
        self.playing = True
        print(f"Now playing: {song.title} by {song.artist}")

    def stop_song(self):
        if self.current_song is not None:
            print(f"Stopping: {self.current_song.title}")
            self.playlist.remove(self.current_song)
            self.playing = False
            self.current_song = None
        else:
            print("No song is currently playing")

    def has_capacity(self):
        return len(self.guests) < self.capacity
    
    