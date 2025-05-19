package LibraryManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class PatronPass {
    private final String name;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final List<Book> books;
    private final List<Book> borrowedHistory;
    private final int maxBookBorrowingCapacity;

    public PatronPass(String name, LocalDate startDate, LocalDate endDate, int maxBookBorrowingCapacity) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.books = new ArrayList<>();
        this.maxBookBorrowingCapacity = maxBookBorrowingCapacity;
        this.borrowedHistory = new ArrayList<>();
    }

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
        this.books.add(book);
        this.borrowedHistory.add(book);
    }

    public boolean deAllocateBook(Book book) {
        System.out.println("Book : " + book.getTitle() + " is deAllocated to : " + name);
        return books.remove(book);
    }
}
