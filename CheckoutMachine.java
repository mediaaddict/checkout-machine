import java.util.ArrayList;

/**
 * CheckoutMachine class represents a machine that scans items against
 * a list of items from the server and adds its info to a cart ArrayList
 * and can get the total price of all the items in cart when finished.
 *
 * @author Alex Thompson
 * @version 3
 */
public class CheckoutMachine {

    private String storeName;
    private ArrayList<Item> validItems = new ArrayList<>();
    private ArrayList<Item> cart = new ArrayList<>();

    /**
     * Creates a new CheckoutMachine with the given storeName, which is
     * checked against the Server for validity. If the storeName is not valid,
     * the unchecked WrongStoreError will be thrown. A ServerException
     * might be randomly thrown.
     *
     * @param  storeName  The name of the store using the machine.
     */
    public CheckoutMachine(String storeName) throws WrongStoreError {
        boolean again = true;
        while (again) {
            try {
                if (Server.isStoreNameValid(storeName)) {
                    this.storeName = storeName;
                    this.validItems = Server.getValidItems();
                } else {
                    throw new WrongStoreError();
                }
                again = false;
            } catch (ServerException e) {
                System.out.println("ServerException caught! Trying again...");
            }
        }
    }

    /**
     * Checks to see if an item is in the Server's list of valid items.
     * If it is, then it is added to the cart ArrayList. If not, an
     * InvalidItemException is thrown.
     *
     * @param item The item to attempt to scan into the cart.
     * @throws InvalidItemException Thrown when an item is not in the database.
     */
    public void scan(Item item) throws InvalidItemException {
        if (validItems.contains(item)) {
            cart.add(validItems.get(validItems.indexOf(item)));
        } else {
            throw new InvalidItemException();
        }
    }

    /**
     * Sums all the prices of the items in the cart and returns that sum.
     *
     * @return A double representing the total price of all Items in cart.
     */
    public double getTotalPrice() {
        if (cart.size() != 0) {
            double total = 0;
            for (Item grocery : cart) {
                total = total + grocery.getPrice();
            }
            return total;
        } else {
            return 0;
        }
    }

    /**
     * Attempts to use the specified PaymentMethod to pay the total price
     * of all the items in the cart. If successful, the cart is emptied.
     * If the PaymentMethod cannot pay the total, a PaymentFailedException
     * is thrown.
     *
     * @param method The PaymentMethod object (Cash, CreditCard, or BuzzCard)
     * to be used to pay the total price.
     * @throws PaymentFailedException Thrown when there is an issue paying
     * with the given PaymentMethod.
     */
    public void payForCart(PaymentMethod method)
    throws PaymentFailedException {
        method.pay(this.getTotalPrice());
        cart.clear();
    }

}