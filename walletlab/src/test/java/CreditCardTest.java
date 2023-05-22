import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    @Test
    public void testCharge() {
        CreditCard creditCard = new CreditCard("1234567890", "05/25", 123, 5000);
        creditCard.charge(100);
        assertEquals(4898, creditCard.getAvailableCredit(), 0.01);
    }
}
