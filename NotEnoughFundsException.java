/**
 * NotEnoughFundsException gets thrown by a PaymentMethod if it doesn't
 * have enough funds to cover the payment.
 *
 * @author Alex Thompson
 * @version 1
 */
public class NotEnoughFundsException extends PaymentFailedException {

    /**
     * Creates a new NotEnoughFundsException with the given message.
     *
     * @param  msg The message of the exception.
     */
    public NotEnoughFundsException(String msg) {
        super(msg);
    }
}