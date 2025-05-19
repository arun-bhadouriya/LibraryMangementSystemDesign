package LibraryManagementSystem;

import java.time.LocalDate;

/**
 * The Human class represents a person in the library management system.
 * It contains basic information about a person such as name and date of birth.
 * This class is used to represent library patrons who can borrow books.
 */
public class Human {
    /**
     * The name of the person.
     */
    private String name;

    /**
     * The date of birth of the person.
     */
    private LocalDate dob;

    /**
     * Constructs a new Human with the specified name and date of birth.
     *
     * @param name The name of the person
     * @param dob  The date of birth of the person
     */
    public Human(String name, LocalDate dob) {
        this.dob = dob;
        this.name = name;
    }

    /**
     * Gets the name of the person.
     *
     * @return The person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the date of birth of the person.
     *
     * @return The person's date of birth
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Sets the date of birth of the person.
     *
     * @param dob The new date of birth to set
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
