/**
 * Card class is an abstract superclass of CreditCard or BuzzCard, extending
 * from PaymentMethod and representing a type of payment that is not Cash.
 *
 * @author Alex Thompson
 * @version 2
 */
public abstract class Card implements PaymentMethod {

    private String ownerName;
    private double balance;

    /**
     * Creates a new Card object in someone's name with the specified amount
     * of money in its balance.
     *
     * @param ownerName The name of the card's owner.
     * @param balance The amount of money on the card.
     */
    public Card(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    /**
     * Pays the given amount if possible. If the amount in balance is
     * less than the payment total, it will throw a NotEnoughFundsException.
     *
     * @param  amount Amount of money to pay.
     * @throws NotEnoughFundsException Thrown if the Card's balance
     * is less than the amount to pay.
     */
    @Override
    public void pay(double amount) throws PaymentFailedException {
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            throw new NotEnoughFundsException("You do not have"
                + " enough funds in balance to cover your total.");
        }
    }

    /**
     * Checks the balance remaining on the card.
     *
     * @return A double representing the card's remaining balance.
     */
    public double getBalance() {
        return balance;
    }

}