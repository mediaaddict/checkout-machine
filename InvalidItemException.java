/**
 * InvalidItemException gets thrown by the CheckoutMachine if an Item scanned
 * is not in the validItems list.
 *
 * @author Alex Thompson
 * @version 1
 */
public class InvalidItemException extends Exception {

    /**
     * Creates a new InvalidItemException. Consists of a message clarifying
     * that an item is an invalid.
     */
    public InvalidItemException() {
        super("This item is not valid.");
    }
}