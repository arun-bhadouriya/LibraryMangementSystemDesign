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
    List<Book> books;

    /**
     * Mapping of library patrons (Human) to their respective PatronPass.
     */
    Map<Human, PatronPass> libraryPasses;

    /**
     * Constructs a new Library instance with an empty inventory of books
     * and no allocated library passes.
     */
    public Library() {
        books = new ArrayList<>();
        libraryPasses = new HashMap<>();
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
     *
     * @param human The patron (Human) to whom the pass is allocated.
     */
    public void allocatePassToLibrary(Human human) {
        libraryPasses.put(human,
                new PatronPass(human.getName(), LocalDate.now(), LocalDate.now().plusYears(1), 5));
    }

    /**
     * Lends a book to a patron if they have a valid library pass and the book is available.
     *
     * @param name The title of the book to be lent.
     * @param h1   The patron (Human) borrowing the book.
     */
    public void lendABook(String name, Human h1) {
        PatronPass p = libraryPasses.get(h1);
        Book b = findBookInLib(name);

        boolean canAssignBook = true;
        if (p == null) {
            System.err.println("Please take a Patron Pass in order to borrow book from the library.");
            canAssignBook = false;
        }

        if (b == null) {
            System.err.println("Sorry, Book is not available in the library.");
            canAssignBook = false;
        }

        if (canAssignBook) {
            p.allocateBook(b);
            books.remove(b);
        }
    }

    /**
     * Finds a book in the library's inventory by its title.
     *
     * @param name The title of the book to search for.
     * @return The Book object if found, or null if the book is not available.
     */
    public Book findBookInLib(String name) {
        for (Book b : books) {
            if (b.getTitle().equals(name)) {
                return b; // returning first book found with name.
            }
        }
        return null;
    }

    //returning a book
    public void returnBook(Human h, Book book) {
        PatronPass p1 = libraryPasses.get(h);
        if (p1 == null) {
            System.err.println("No such member found in the library , " + h.getName());
            return;
        }

        p1.deAllocateBook(book);
        books.add(book);
    }

    // Todo : Add extensionn to search functionalities
    // Todo : Add return the books methodology
    // Todo : Add payment processing for the book upon the return.
}
