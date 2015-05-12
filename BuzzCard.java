/**
 * BuzzCard class represents the use of a BuzzCard as a specific Card object
 * of PaymentMethod.
 *
 * @author Alex Thompson
 * @version 2
 */
public class BuzzCard extends Card {

    /**
     * Creates a new BuzzCard object with the specified amount of money
     * and a owner's name.
     *
     * @param ownerName  The name of the card's owner.
     * @param balance The amount of money on the card.
     */
    public BuzzCard(String ownerName, double balance) {
        super(ownerName, balance);
    }
}