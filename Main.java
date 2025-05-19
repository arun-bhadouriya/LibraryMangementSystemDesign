package LibraryManagementSystem;

import java.time.LocalDate;
import java.time.Month;

/**
 * The main class serves as the entry point for the Library Management System application.
 * It demonstrates the usage of the library system by creating a library, adding books,
 * creating patrons, allocating library passes, and lending books.
 */
public class Main {
    /**
     * The main method that serves as the entry point for the application.
     * It demonstrates the basic functionality of the Library Management System:
     * - Creating a library
     * - Adding books to the library
     * - Creating patrons
     * - Allocating library passes to patrons
     * - Lending books to patrons
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Library lib1 = new Library();

//        Book b1 = new Book("An Eco-Critical Appraisal of the Selected", "Rabia Mukhtar", "978-81-933904-9-8", 2018);
//        Book b2 = new Book("ACCIDENTS DO NOT HAPPEN", "Dr Sankar Rajeev", "978-81-933904-8-1", 2018);
//        Book b3 = new Book("SANSRITI", "Dr Vibha Manoj Sharma", "978-81-933904-0-5", 2017);

//        logger.log(Level.INFO, "Adding books to the library...");
        lib1.addBook(new Book("An Eco-Critical Appraisal of the Selected", "Rabia Mukhtar", "978-81-933904-9-8", 2018));
        lib1.addBook(new Book("ACCIDENTS DO NOT HAPPEN", "Dr Sankar Rajeev", "978-81-933904-8-1", 2018));
        lib1.addBook(new Book("SANSRITI", "Dr Vibha Manoj Sharma", "978-81-933904-0-5", 2017));

        Human h1 = new Human("Arun", LocalDate.of(2000, Month.DECEMBER, 8));
        Human h2 = new Human("Shivam", LocalDate.of(2000, Month.DECEMBER, 8));

        lib1.allocatePassToLibrary(h1);
        lib1.allocatePassToLibrary(h2);

        lib1.allocateBook("978-81-933904-8-1", h1);
        lib1.allocateBook("978-81-933904-0-5", h2);
        lib1.returnABook("978-81-933904-0-5", h1, new CCPayment("1234-5678-9098-7654"));
//        System.out.println("Hello");
    }
}
