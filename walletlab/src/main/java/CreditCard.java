public class CreditCard extends PaymentCard {
    private double availableCredit;

    public CreditCard(String cardNumber, String expiryDate, int securityNumber, double availableCredit) {
        super(cardNumber, expiryDate, securityNumber);
        this.availableCredit = availableCredit;
    }

    public double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(double availableCredit) {
        this.availableCredit = availableCredit;
    }

    @Override
    public void charge(double purchaseAmount) {
        double transactionCost = purchaseAmount * 1.02;
        if (transactionCost <= availableCredit) {

            availableCredit -= transactionCost;

            logTransaction(transactionCost);

        } else {
            System.out.println("Insufficient credit available.");
        }
    }
}
