package LibraryManagementSystem;

import java.time.LocalDate;

public class Human {
    private String name;
    private LocalDate dob;

    public Human(String name, LocalDate dob) {
        this.dob = dob;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
