package LibraryManagementSystem;

/**
 * The PaymentProcessor interface defines a strategy for processing payments.
 * It follows the Strategy design pattern, allowing different payment methods
 * to be implemented and used interchangeably.
 * This interface is used for processing payments such as late fees in the library system.
 */
public interface PaymentProcessor {
    /**
     * Processes a payment of the specified amount.
     *
     * @param amount The amount to be paid in the library's currency
     */
    void pay(long amount);
}
