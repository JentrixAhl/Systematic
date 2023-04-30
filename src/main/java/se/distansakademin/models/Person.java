package se.distansakademin.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String yearOfBirth;

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Person(String firstName, String yearOfBirth) {
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;

    }
}
