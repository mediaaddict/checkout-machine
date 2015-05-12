/**
 * CreditCard class represents the use of a credit card as a PaymentMethod.
 *
 * @author Alex Thompson
 * @version 2
 */
public class CreditCard extends Card {

    private java.time.LocalDate expirationDate;

    /**
     * Creates a new CreditCard object with the specified amount of money
     * and a date of expiration.
     *
     * @param ownerName The name of the card's owner.
     * @param balance The amount of money on the card.
     * @param expirationDate The date on which the card is/was set to expire.
     */
    public CreditCard(String ownerName, double balance,
        java.time.LocalDate expirationDate) {
        super(ownerName, balance);
        this.expirationDate = expirationDate;
    }

    /**
     * Pays the given amount if possible. Overrides the super method to
     * check if the card is expired before checking balance.
     * If the expirationDate is before today's date,
     * it will throw a CardExpiredException.
     * If the amount in balance is less than the payment total,
     * it will throw a NotEnoughFundsException.
     *
     * @param  amount  Amount of money to pay.
     * @throws CardExpiredException Thrown if the Card's expirationDate
     * is before today's date.
     * @throws NotEnoughFundsException Thrown if the Card's balance
     * is less than the amount to pay.
     */
    @Override
    public void pay(double amount) throws PaymentFailedException {

        if (expirationDate.isBefore(java.time.LocalDate.now())) {
            throw new CardExpiredException(expirationDate);
        } else {
            super.pay(amount);
        }
    }
}