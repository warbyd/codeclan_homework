public class GiftCard implements IChargeable {
    private double balance;

    public GiftCard(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void charge(double purchaseAmount) {
        if (purchaseAmount <= balance) {
            // Reduces balance
            balance -= purchaseAmount;
        } else {
            System.out.println("Insufficient balance in GiftCard.");
        }
    }
}
