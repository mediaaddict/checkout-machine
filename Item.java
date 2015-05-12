/**
 * Item class represents an item, having name, weight, price, and barcode.
 * @author Alex Epifano &amp; Thomas Shields
 * @version 1.0
 */
public class Item {

    private String name;
    private double weight;
    private double price;
    private long barcode;

    /**
     * Creates a new item with the specified weight and barcode. Initializes
     * name as null and price as 0.0.
     * @param  weight  The weight in grams of the item.
     * @param  barcode The barcode of the item.
     */
    public Item(double weight, long barcode) {
        this(null, weight, 0.0, barcode);
    }

    /**
     * Create new item with the specified properties.
     * @param  name    The name of the item.
     * @param  weight  The weight of the item in grams.
     * @param  price   The price of the item in USD.
     * @param  barcode The barcode of the item.
     */
    public Item(String name, double weight, double price, long barcode) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.barcode = barcode;
    }

    /**
     * Returns the Item's price.
     *
     * @return A double representing the Item's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Overrides the default equals method to check for equality in Item
     * objects based on their weight and barcode.
     *
     * @param that The object to which you are comparing the Item to.
     * @return A boolean stating whether two Items are the same: true if they
     * are, false if they aren't.
     */
    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        if (this == that) {
            return true;
        }
        if (!(that instanceof Item)) {
            return false;
        }
        Item compare = (Item) that;
        return (this.weight == compare.weight
            && this.barcode == compare.barcode);
    }
}
