package LibraryManagementSystem;

/**
 * The Finder interface defines a strategy for searching books in the library.
 * It follows the Strategy design pattern, allowing different search algorithms
 * to be implemented and used interchangeably.
 */
public interface Finder {
    /**
     * Searches for a book in the library based on a search key.
     *
     * @param lib The library in which to search for the book
     * @param key The search key (could be title, ISBN, etc. depending on implementation)
     * @return The found book, or null if no matching book is found
     */
    Book search(Library lib, String key);
}
