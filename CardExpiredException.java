/**
 * CardExpiredException gets thrown by a CreditCard if its expirationDate
 * is before the current date.
 *
 * @author Alex Thompson
 * @version 1
 */
public class CardExpiredException extends PaymentFailedException {

    /**
     * Creates a new CardExpiredException with a message saying the date
     * that the Card expired.
     *
     * @param  d The Card's expiration date, as a LocalDate.
     */
    public CardExpiredException(java.time.LocalDate d) {
        super("Card expired on " + d.toString() + ".");
    }
}