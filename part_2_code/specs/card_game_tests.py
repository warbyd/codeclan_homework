import unittest
from src.card import Card
from src.card_game import CardGame


class TestCardGame(unittest.TestCase):
    def setUp(self):
        # Create some sample cards for testing
        self.card1 = Card("Spades", 5)
        self.card2 = Card("Hearts", 10)
        self.card3 = Card("Diamonds", 1)
        self.card4 = Card("Clubs", 7)

    def test_check_for_ace(self):
        # Create an instance of CardGame
        game = CardGame()

        # Test check_for_ace() method with various cards
        self.assertFalse(game.check_for_ace(self.card1))  # 5 is not an ace
        self.assertFalse(game.check_for_ace(self.card2))  # 10 is not an ace
        self.assertTrue(game.check_for_ace(self.card3))   # 1 is an ace
        self.assertFalse(game.check_for_ace(self.card4))  # 7 is not an ace

    def test_highest_card(self):
        # Create an instance of CardGame
        game = CardGame()

        # Test highest_card() method with various cards
        self.assertEqual(game.highest_card(self.card1, self.card2), self.card2)  # 10 is higher than 5
        self.assertEqual(game.highest_card(self.card3, self.card4), self.card4)  # 7 is higher than 1
        self.assertEqual(game.highest_card(self.card2, self.card4), self.card2)  # 10 is higher than 7

    def test_cards_total(self):
        # Create an instance of CardGame
        game = CardGame()

        # Create a list of cards for testing
        cards = [self.card1, self.card2, self.card3, self.card4]

        # Test cards_total() method with the list of cards
        self.assertEqual(game.cards_total(cards), "You have a total of 23")  # 5 + 10 + 1 + 7 = 23

if __name__ == '__main__':
    unittest.main()
