import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private List<IChargeable> cards = new ArrayList<>();
    private IChargeable selectedCard;

    public void addCard(IChargeable card) {
        cards.add(card);
    }

    public void selectCard(IChargeable card) {
        // Check if the card exists in the wallet before setting it as selected
        if (cards.contains(card)) {
            selectedCard = card;
        } else {
            System.out.println("Card does not exist in the wallet.");
        }
    }

    public void pay(double purchaseAmount) {
        if (selectedCard != null) {
            selectedCard.charge(purchaseAmount);
        } else {
            System.out.println("No card selected.");
        }
    }
}
