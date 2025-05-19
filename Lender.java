package LibraryManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * The Lender class is responsible for managing the lending and returning of books in the library.
 * It handles the process of lending books to patrons, checking for valid patron passes,
 * and processing returns including calculating and collecting late fees.
 */
public class Lender {
//    Finder finder;
//    public Lender(Finder finder){
//        this.finder = finder;
//    }

    /**
     * The cost per day for borrowing a book, used to calculate late fees.
     */
    private static final int CostPerDay = 10;

    /**
     * Lends a book to a patron if they have a valid library pass and the book is available.
     * The book is found using the provided finder strategy and ISBN.
     *
     * @param lib    The library from which to lend the book
     * @param finder The strategy to use for finding the book
     * @param human  The patron who wants to borrow the book
     * @param ISBN   The ISBN of the book to be borrowed
     */
    public void lentABook(Library lib, Finder finder, Human human, String ISBN) {
        PatronPass pass = lib.findPass(human);
        if (pass == null) {
            System.err.println("Please take a Patron Pass in order to borrow book from the library.");
            return;
        }

        Book book = finder.search(lib, ISBN); // always a unique book by ISBN
        if (book == null) {
            System.err.println("Book is either not available or not in the library.");
            return;
        }

        pass.allocateBook(book); // allocating book to a particular human LibraryPass .
    }

    /**
     * Processes the return of a book by a patron, calculating and collecting any fees.
     * The fee is calculated based on the number of days the book was borrowed multiplied by the cost per day.
     *
     * @param lib    The library to which the book is being returned
     * @param human  The patron who is returning the book
     * @param ISBN   The ISBN of the book being returned
     * @param finder The strategy to use for finding the book
     * @param pp     The payment processor to use for collecting fees
     */
    public void returnABook(Library lib, Human human, String ISBN, Finder finder, PaymentProcessor pp) {
        PatronPass pass = lib.findPass(human);

        if (pass == null) {
            System.err.println("Please take a Patron Pass in order to borrow book from the library.");
            return;
        }

        Book book = finder.search(lib, ISBN);
        if (book == null) {
            return;
        }

        LocalDate issuedDate = pass.getBookIssuedDate(book);
        long amount = ChronoUnit.DAYS.between(issuedDate, LocalDate.now()) * (Lender.CostPerDay);
        pp.pay(amount);

        pass.deAllocateBook(book);
    }
}
