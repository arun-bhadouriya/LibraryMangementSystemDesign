package LibraryManagementSystem;

/**
 * The FindByTitle class implements the Finder interface to provide
 * a search strategy for finding books by their title.
 * It searches through the library's collection and returns the first available book
 * that matches the provided title.
 */
public class FindByTitle implements Finder {

    /**
     * Searches for a book in the library by its title.
     * Only returns books that are currently available (not checked out).
     *
     * @param lib The library in which to search for the book
     * @param key The title of the book to search for
     * @return The first available book with the matching title, or null if no matching available book is found
     */
    @Override
    public Book search(Library lib, String key) {
        for (Book book : lib.getBooks()) {
            if (book.getTitle().equals(key) && book.isAvailable()) {
                return book; // returns the first book found
            }
        }
        return null;
    }
}
