/**
 * Cash class represents a cash payment with a set value of the amount of
 * cash on hand.
 *
 * @author Alex Thompson
 * @version 1
 */
public class Cash implements PaymentMethod {

    private double cashOnHand;

    /**
     * Creates a new Cash object with the specified amount of money.
     *
     * @param  cashOnHand  The starting total amount of money in cash.
     */
    public Cash(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }

    /**
     * Pays the given amount if possible, throws a NotEnoughFundsException if
     * something goes wrong. Overrides the super method to include subtract the
     * payment from the amount of cashOnHand. If the amount of cashOnHand is
     * less than the payment total, it will throw a NotEnoughFundsException.
     *
     * @param  amount Amount of money to pay.
     * @throws NotEnoughFundsException Thrown if the amount of cashOnHand
     * is less than the amount to pay.
     */
    @Override
    public void pay(double amount) throws NotEnoughFundsException {
        if (cashOnHand >= amount) {
            cashOnHand = cashOnHand - amount;
        } else {
            throw new NotEnoughFundsException("You do not have"
                + " enough cash to cover your total.");
        }
    }

    /**
     * Checks the amount of money in cash.
     *
     * @return A double representing the amount of cashOnHand.
     */
    public double getCashOnHand() {
        return cashOnHand;
    }
}