# Library Management System

    - Core Requirements

    1. Book Management
    
    2. Implement a Book class with attributes such as title, author, ISBN, and publication year.
    
    3. Create a system to add, remove, and update books in the library inventory.
    
    4. Implement a search functionality to find books by title, author, or ISBN.
    
    - Patron Management
    
    1. Design a Patron class to represent library members.
    
    2. Implement functionality to add new patrons and update their information.
    
    3. Create a system to track patron borrowing history.
    
    - Lending Process
    
    1. Implement book checkout and return functionalities.
    
    - Inventory Management
    
    1. Keep track of available and borrowed books.

### Functional Requirements :

    1. Able to create a Book.

    2. Add or remove or update the book in a library (Library class).
    
    3. Efficiently search a book from the Library.

    4. Able to add patrons in a Library.
    
    5. Able to store data of patron books borrowing.

    6. Able to borrow a book from the library and generate pricing according to the time borrowed.
    
    7. Able to identify available and non-available book.

### Classes :

    1. Book - Simulation of a book (Real world enitiy).
    2. Human - Simlation of a Human (Real world entity).
    3. PatronPass - Pass given to the Human for the library.
    4. Finder - Searching algorithms to use to search a book ( a strategy can be used to search )  {FindByISBN, FindBuTitle}
    5. Library - Simulation of a Library (Real world entity).
    6. PaymentProcessor - checkout management wrt book borrowing time. (per day cost). + supported all payment options.

## UML :

    1. Book :
        - title
        - author
        - publishedYear
        - ISBN
        - isAvailable
    
    2. Human :
        - name
        - dob
    
    3. PatronPass :
        - name
        - dob
        - startDate
        - endDate

    4. QueryPass : 
        - Searcher
        + find(Sring title)
        + find(String author)
    
    5. Library : 
        - List<Book> books
        - QueryPass qp
        - Map<Human, PatronPass> libraryMembers;
        + addBook(Book book)
        + removeBook(Book book)
        + updateBook(Book book, String field, String value)
        + allocateBook
        + deAllocateBook

    6. PaymentProcessor : 
        - pay(long amount)
        
    7. CCPayment : (can add more strategies to pay) 
        - ccNumber
        + pay(long amount)

    8. Finder : 
        - search(Library lib, String key)
    
    9. FindByTitle
    10. FindByISBN

    