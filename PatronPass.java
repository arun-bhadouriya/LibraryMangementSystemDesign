package LibraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The PatronPass class represents a library membership card for patrons.
 * It tracks the validity period of the membership, the books currently borrowed by the patron,
 * the borrowing history, and enforces borrowing limits.
 * This class is responsible for managing book allocation and deallocation for a patron.
 */
public class PatronPass {
    /**
     * The name of the patron who owns this pass.
     */
    private final String name;

    /**
     * The date when this pass becomes valid.
     */
    private final LocalDate startDate;

    /**
     * The date when this pass expires.
     */
    private final LocalDate endDate;

    /**
     * Map of books currently borrowed by the patron and their issue dates.
     */
    private final Map<Book, LocalDate> books;

    /**
     * List of all books that have been borrowed by the patron (including returned ones).
     */
    private final List<Book> borrowedHistory;

    /**
     * The maximum number of books that can be borrowed simultaneously.
     */
    private final int maxBookBorrowingCapacity;

    /**
     * Constructs a new PatronPass with the specified details.
     *
     * @param name                     The name of the patron
     * @param startDate                The date when the pass becomes valid
     * @param endDate                  The date when the pass expires
     * @param maxBookBorrowingCapacity The maximum number of books that can be borrowed simultaneously
     */
    public PatronPass(String name, LocalDate startDate, LocalDate endDate, int maxBookBorrowingCapacity) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.books = new HashMap<>();
        this.maxBookBorrowingCapacity = maxBookBorrowingCapacity;
        this.borrowedHistory = new ArrayList<>();
    }

    /**
     * Allocates a book to the patron if the pass is valid and the borrowing limit is not reached.
     * The book is marked as unavailable and added to the patron's borrowed books.
     *
     * @param book The book to be allocated to the patron
     */
    public void allocateBook(Book book) {
        if (endDate.isEqual(LocalDate.now())) {
            System.err.println("Please renew your PASS : Mr. " + name);
            return;
        }

        if (books.size() == maxBookBorrowingCapacity) {
            System.err.println("Reached max borrowing capacity of : " + maxBookBorrowingCapacity + " books.");
            return;
        }

        System.out.println("Book : " + book.getTitle() + " is allocated to : " + name);
        this.books.put(book, LocalDate.now());
        this.borrowedHistory.add(book);
        book.setAvailable(false);
    }

    /**
     * Deallocates a book from the patron, marking it as available for other patrons.
     * The book is removed from the patron's currently borrowed books but remains in the borrowing history.
     *
     * @param book The book to be returned by the patron
     */
    public void deAllocateBook(Book book) {
        System.out.println("Book : " + book.getTitle() + " is deAllocated to : " + name);
        book.setAvailable(true);
        books.remove(book);
    }

    /**
     * Gets the date when a specific book was issued to the patron.
     *
     * @param book The book for which to get the issue date
     * @return The date when the book was issued, or null if the book is not currently borrowed by this patron
     */
    public LocalDate getBookIssuedDate(Book book) {
        return this.books.get(book);
    }
}
