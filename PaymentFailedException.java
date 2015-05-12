/**
 * PaymentFailedException gets thrown by a PaymentMethod
 * if a payment goes wrong.
 *
 * @author Alex Thompson
 * @version 1
 */
public class PaymentFailedException extends Exception {

    /**
     * Creates a new PaymentFailedException with the given message.
     *
     * @param  msg The message of the exception.
     */
    public PaymentFailedException(String msg) {
        super(msg);
    }
}