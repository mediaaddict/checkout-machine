/**
 * WrongStoreError gets thrown by the CheckoutMachine if its storeName
 * is not a valid name in the Server.
 *
 * @author Alex Thompson
 * @version 1
 */
public class WrongStoreError extends Error {

    /**
     * Creates a new WrongStoreError.
     */
    public WrongStoreError() {
        super();
    }
}