public class DebitCard extends PaymentCard {
    private String accountNumber;
    private String sortCode;

    public DebitCard(String cardNumber, String expiryDate, int securityNumber, String accountNumber, String sortCode) {
        super(cardNumber, expiryDate, securityNumber);
        this.accountNumber = accountNumber;
        this.sortCode = sortCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    @Override
    public void charge(double purchaseAmount) {

        logTransaction(purchaseAmount);

    }
}
