import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GiftCardTest {

    @Test
    public void testCharge() {
        GiftCard giftCard = new GiftCard(500);
        giftCard.charge(100);
        assertEquals(400, giftCard.getBalance(), 0.01);
    }
}
