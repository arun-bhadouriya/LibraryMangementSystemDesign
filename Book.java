package LibraryManagementSystem;

/**
 * The Book class represents a book in the library management system.
 * It contains information about the book such as title, author, ISBN,
 * published year, and availability status.
 */
public class Book {
    /**
     * The title of the book.
     */
    private String title;

    /**
     * The author of the book.
     */
    private String author;

    /**
     * The International Standard Book Number (ISBN) that uniquely identifies the book.
     */
    private String ISBN;

    /**
     * The year in which the book was published.
     */
    private int publishedYear;

    /**
     * Flag indicating whether the book is currently available for lending.
     */
    private boolean isAvailable;

    /**
     * Constructs a new Book with the specified details.
     *
     * @param title         The title of the book
     * @param author        The author of the book
     * @param ISBN          The International Standard Book Number
     * @param publishedYear The year the book was published
     */
    public Book(String title, String author, String ISBN, int publishedYear) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publishedYear = publishedYear;
        this.isAvailable = true;
    }

    /**
     * Gets the title of the book.
     *
     * @return The book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return The book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return The book's ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Gets the published year of the book.
     *
     * @return The year the book was published
     */
    public int getPublishedYear() {
        return publishedYear;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The new title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the author of the book.
     *
     * @param author The new author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param ISBN The new ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * Sets the published year of the book.
     *
     * @param publishedYear The new published year to set
     */
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    /**
     * Checks if the book is available for lending.
     *
     * @return true if the book is available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets the availability status of the book.
     *
     * @param available true to mark the book as available, false otherwise
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
