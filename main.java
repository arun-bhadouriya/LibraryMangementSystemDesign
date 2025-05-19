package LibraryManagementSystem;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(main.class.getName());
        Library lib1 = new Library();

        Book b1 = new Book("An Eco-Critical Appraisal of the Selected", "Rabia Mukhtar", "978-81-933904-9-8", 2018);
        Book b2 = new Book("ACCIDENTS DO NOT HAPPEN", "Dr Sankar Rajeev", "978-81-933904-8-1", 2018);
        Book b3 = new Book("SANSRITI", "Dr.Vibha Manoj Sharma", "978-81-933904-0-5", 2017);

//        logger.log(Level.INFO, "Adding books to the library...");
        lib1.addBook(b1);
        lib1.addBook(b2);
        lib1.addBook(b3);

        Human h1 = new Human("Arun", LocalDate.of(2000, Month.DECEMBER, 8));
        Human h2 = new Human("Shivam", LocalDate.of(2000, Month.DECEMBER, 8));

//        logger.log(Level.INFO, "Allocating library passes...");
        lib1.allocatePassToLibrary(h1);
        lib1.allocatePassToLibrary(h2);
//        logger.log(Level.INFO, "Library passes allocated successfully.");

//        logger.log(Level.INFO, "Lending books...");
        lib1.lendABook("ACCIDENTS DO NOT HAPPEN", h1);
        lib1.lendABook("ACCIDENTS DO NOT HAPPEN", h2);
        lib1.returnBook(h1, b2);
//        logger.log(Level.INFO, "Book lending process completed.");

        System.out.println("Hello");
    }
}
