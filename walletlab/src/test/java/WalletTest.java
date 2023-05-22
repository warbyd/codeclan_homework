import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {

    @Test
    public void testAddAndSelectCard() {
        Wallet wallet = new Wallet();
        DebitCard debitCard = new DebitCard("1234567890", "05/25", 123, "0987654321", "112233");
        wallet.addCard(debitCard);
        wallet.selectCard(debitCard);
        wallet.pay(100);
        assertFalse(debitCard.getTransactionLog().isEmpty());
    }
}
