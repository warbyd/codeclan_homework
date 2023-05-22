import java.util.ArrayList;
import java.util.List;

public abstract class PaymentCard implements IChargeable {
    private String cardNumber;
    private String expiryDate;
    private int securityNumber;
    private List<String> transactionLog;

    public PaymentCard(String cardNumber, String expiryDate, int securityNumber) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.securityNumber = securityNumber;
        this.transactionLog = new ArrayList<>();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(int securityNumber) {
        this.securityNumber = securityNumber;
    }

    public List<String> getTransactionLog() {
        return transactionLog;
    }

    public void logTransaction(double amount) {
        transactionLog.add("Transaction of " + amount + " at " + java.time.LocalDateTime.now());
    }

    @Override
    public void charge(double purchaseAmount) {
        // This method is abstract and needs to be overridden in the subclasses
        throw new UnsupportedOperationException();
    }
}

