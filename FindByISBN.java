package LibraryManagementSystem;

/**
 * The FindByISBN class implements the Finder interface to provide
 * a search strategy for finding books by their ISBN (International Standard Book Number).
 * It searches through the library's collection and returns the first available book
 * that matches the provided ISBN.
 */
public class FindByISBN implements Finder {
    /**
     * Searches for a book in the library by its ISBN.
     * Only returns books that are currently available (not checked out).
     *
     * @param lib The library in which to search for the book
     * @param key The ISBN of the book to search for
     * @return The found book if available, or null if no matching book is found
     */
    @Override
    public Book search(Library lib, String key) {
        for (Book book : lib.getBooks()) {
            if (book.getISBN().equals(key) && book.isAvailable()) {
                return book;
            }
        }
        return null;
    }
}
