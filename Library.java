package LibraryManagementSystem;

import java.time.LocalDate;
import java.util.*;

/**
 * The Library class represents a library management system.
 * It provides functionality to manage books and library passes,
 * including adding/removing books, allocating passes, and lending books to patrons.
 */
public class Library {
    /**
     * List of books available in the library.
     */
    private final List<Book> books;

    /**
     * Mapping of library patrons (Human) to their respective PatronPass.
     */
    private final Map<Human, PatronPass> libraryPasses;

    /**
     * The lender responsible for handling book lending and returning operations.
     */
    private final Lender lender;

    /**
     * Constructs a new Library instance with an empty inventory of books
     * and no allocated library passes.
     */
    public Library() {
        books = new ArrayList<>();
        libraryPasses = new HashMap<>();
        lender = new Lender();
    }


    /**
     * Adds a book to the library's inventory.
     *
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the library's inventory.
     *
     * @param book The book to be removed.
     * @return true if the book was successfully removed, false otherwise.
     */
    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    /**
     * Allocates a library pass to a patron.
     * Creates a new PatronPass valid for one year with a borrowing limit of 5 books.
     *
     * @param human The patron (Human) to whom the pass is allocated.
     */
    public void allocatePassToLibrary(Human human) {
        libraryPasses.put(human,
                new PatronPass(human.getName(), LocalDate.now(), LocalDate.now().plusYears(1), 5));
    }

    /**
     * Allocates a book to a patron by its ISBN.
     * This method delegates to the lender to handle the book lending process.
     *
     * @param ISBN The ISBN of the book to be allocated
     * @param h    The patron (Human) to whom the book will be allocated
     */
    public void allocateBook(String ISBN, Human h) {
        lender.lentABook(this, new FindByISBN(), h, ISBN);
    }

    /**
     * Processes the return of a book by a patron.
     * This method delegates to the lender to handle the book return process,
     * including calculating and collecting any fees.
     *
     * @param ISBN The ISBN of the book being returned
     * @param h    The patron (Human) who is returning the book
     * @param pp   The payment processor to use for collecting fees
     */
    public void returnABook(String ISBN, Human h, PaymentProcessor pp) {
        lender.returnABook(this, h, ISBN, new FindByISBN(), pp);
    }

//    /**
//     * Lends a book to a patron if they have a valid library pass and the book is available.
//     *
//     * @param ISBN The ISBN of the book to be lent.
//     * @param h1   The patron (Human) borrowing the book.
//     */
//    public void lendABook(String ISBN, Human h1) {
//        PatronPass p = libraryPasses.get(h1);
//        Book b = findBookInLibByISBN(ISBN);
//
//        boolean canAssignBook = true;
//        if (p == null) {
//            System.err.println("Please take a Patron Pass in order to borrow book from the library.");
//            canAssignBook = false;
//        }
//
//        if (b == null) {
//            System.err.println("Sorry, Book is not available in the library.");
//            canAssignBook = false;
//        }
//
//        if (canAssignBook) {
//            p.allocateBook(b);
//            books.remove(b);
//        }
//    }

//    /**
//     * Finds a book in the library's inventory by its title.
//     *
//     * @param title The title of the book to search for.
//     * @return The Book object if found, or null if the book is not available.
//     */
//    public List<Book> findBookInLibByTitle(String title) {
//        List<Book> booksList = new ArrayList<>();
//        for (Book b : books) {
//            if (b.getTitle().equals(title)) {
//                booksList.add(b);
//            }
//        }
//        return booksList;
//    }
//
//
//    public Book findBookInLibByTitleAndAuthor(String title, String author) {
//        for (Book b : books) {
//            if (b.getTitle().equals(title) && b.getAuthor().equals(author)) {
//                return b; // returning exact match book by same title and author
//            }
//        }
//        return null;
//    }
//
//    public List<Book> findAllBooksInLibByAuthorName(String author) {
//        List<Book> booksFound = new ArrayList<>();
//        for (Book b : books) {
//            if (b.getAuthor().equals(author)) {
//                booksFound.add(b);
//            }
//        }
//        return booksFound;
//    }
//
//    public Book findBookInLibByISBN(String ISBN) {
//        for (Book b : books) {
//            if (b.getISBN().equals(ISBN)) return b;
//        }
//        return null;
//    }

    //returning a book
//    public void returnBook(Human h, Book book) {
//        PatronPass p1 = libraryPasses.get(h);
//        if (p1 == null) {
//            System.err.println("No such member found in the library , " + h.getName());
//            return;
//        }
//
//        p1.deAllocateBook(book);
//        books.add(book);
//    }


    /**
     * Gets the list of all books in the library's inventory.
     *
     * @return A list of all books in the library
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Gets the mapping of library patrons to their respective passes.
     *
     * @return A map with Human objects as keys and their PatronPass objects as values
     */
    public Map<Human, PatronPass> getLibraryPasses() {
        return libraryPasses;
    }

    /**
     * Finds a patron's library pass.
     *
     * @param h The patron (Human) whose pass to find
     * @return The patron's PatronPass if they have one, or null if they don't
     */
    public PatronPass findPass(Human h) {
        return libraryPasses.get(h);
    }
}
