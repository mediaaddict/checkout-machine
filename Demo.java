/**
 * Demonstrates the usage of all classes within this package and the
 * utilization of the CheckoutMachine, while printing messages informing
 * the user of when errors are caught.
 *
 * @author Alex Thompson
 * @version 4
 */
public class Demo {

    /**
     * Runs the Demo class.
     *
     * @param args None needed.
     * @throws InvalidItemException Thrown when an item is not in the database.
     * @throws PaymentFailedException Thrown when there is an issue paying
     * with the given PaymentMethod.
     */
    public static void main(String[] args) throws InvalidItemException,
    PaymentFailedException {

        //Tests creation of CheckoutMachine and catching of WrongStoreError.
        //Additional message will print if ServerException is randomly caught.
        try {
            System.out.println("\nCreating new 7-Eleven CheckoutMachine...");
            CheckoutMachine test1 = new CheckoutMachine("7-Eleven");
        } catch (WrongStoreError e) {
            System.out.println("This store is invalid!");
        }
        System.out.println("Creating new TechConvenience CheckoutMachine");
        CheckoutMachine test = new CheckoutMachine("TechConvenience");
        System.out.println("Success!\n");

        //Tests creation of item not in database, catching of
        //InvalidItemException, and the scan() method.
        try {
            System.out.println("Scanning milk....");
            Item milk = new Item(330.2, 432);
            test.scan(milk);
        } catch (InvalidItemException e) {
            System.out.println(e.getMessage());
            System.out.println("Scanning Ground coffee and Ramen 12-pack");
            Item coffee = new Item(961.05, 9220570);
            Item ramen = new Item(74.84, 12);
            test.scan(coffee);
            test.scan(ramen);
        }

        //Tests getTotalPrice(), creation of Cash, usage of payForCart() using
        //cash, and catching of NotEnoughFundsException.
        try {
            System.out.printf("The total is %.2f.%n", test.getTotalPrice());
            System.out.println("Trying to pay with $20 Cash....");
            Cash cash1 = new Cash(20);
            test.payForCart(cash1);
        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Trying to pay with $30 Cash");
            Cash cash2 = new Cash(30);
            test.payForCart(cash2);
            System.out.printf("Success! You now have $%.2f in cash.\n\n",
                cash2.getCashOnHand());
        }

        //Tests creation of BuzzCard, usage of payForCart() using BuzzCard,
        //Item's double constructor, and catching of PaymentFailedException.
        try {
            System.out.println("Next grocery run...");
            System.out.println("Scanning Mac and Cheese 5-pack");
            Item mac = new Item("CheesyMac", 1028.8, 2, 9237204);
            test.scan(mac);
            System.out.printf("The total is %.2f.%n", test.getTotalPrice());
            System.out.println("Trying to pay with empty BuzzCard...");
            BuzzCard buzz1 = new BuzzCard("George P. Burdell", 0);
            test.payForCart(buzz1);
        } catch (PaymentFailedException e) {
            System.out.println(e.getMessage());
            System.out.println("Trying to pay with full BuzzCard");
            BuzzCard buzz2 = new BuzzCard("George P. Burdell", 120);
            test.payForCart(buzz2);
            System.out.printf("Success! You now have $%.2f in BuzzFunds.\n\n",
                buzz2.getBalance());
        }

        //Tests creation of CreditCard, usage of payForCart() using
        //CreditCard, the usage of java.time.LocalDate, and the catching of
        //CreditExpiredException.
        try {
            System.out.println("Next grocery run...");
            System.out.println("Scanning Frozen pizza and Energy Drink pack");
            Item pizza = new Item(902.93, 9263670);
            Item energy = new Item(546.86, 550759400);
            test.scan(pizza);
            test.scan(energy);
            System.out.printf("The total is %.2f.%n", test.getTotalPrice());
            java.time.LocalDate today = java.time.LocalDate.now();
            System.out.print("Today's date is ");
            System.out.println(today);
            java.time.LocalDate exp1 = java.time.LocalDate.of(1985, 10, 11);
            System.out.println("You see your CreditCard has expired.");
            System.out.println("Trying to pay with CreditCard anyway...");
            CreditCard credit1 = new CreditCard("Myself", 100, exp1);
            test.payForCart(credit1);
        } catch (CardExpiredException e) {
            System.out.println(e.getMessage());
            java.time.LocalDate exp2 = java.time.LocalDate.of(2016, 11, 27);
            System.out.print("Your next CreditCard expires on ");
            System.out.println(exp2);
            System.out.println("Trying to pay with next CreditCard");
            CreditCard credit2 = new CreditCard("Myself", 100, exp2);
            test.payForCart(credit2);
            System.out.printf("Success! You now have $%.2f in your account.\n",
                credit2.getBalance());
        }
    }
}