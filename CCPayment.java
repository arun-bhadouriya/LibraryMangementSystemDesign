package LibraryManagementSystem;

/**
 * The CCPayment class implements the PaymentProcessor interface to provide
 * a payment method using a credit card.
 * This class is used to process payments for library services such as late fees.
 */
public class CCPayment implements PaymentProcessor {
    /**
     * The credit card number used for payment processing.
     */
    private final String ccNumber;

    /**
     * Constructs a new CCPayment with the specified credit card number.
     *
     * @param ccNumber The credit card number to be used for payments
     */
    public CCPayment(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    /**
     * Processes a payment using a credit card.
     * This method simulates a credit card payment by printing a confirmation message.
     *
     * @param amount The amount to be paid in the library's currency
     */
    @Override
    public void pay(long amount) {
        System.out.println("Paid : " + amount + ", using credit card (" + (ccNumber) + ")");
    }
}
