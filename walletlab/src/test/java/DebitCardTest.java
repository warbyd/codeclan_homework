import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DebitCardTest {

    @Test
    public void testCharge() {
        DebitCard debitCard = new DebitCard("1234567890", "05/25", 123, "0987654321", "112233");
        debitCard.charge(100);
        assertFalse(debitCard.getTransactionLog().isEmpty());
    }
}
