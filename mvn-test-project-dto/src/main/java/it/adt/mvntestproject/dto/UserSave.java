package it.adt.mvntestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserSave {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserSave userSave = (UserSave) o;
        return Objects.equals(this.firstName, userSave.firstName) &&
                Objects.equals(this.lastName, userSave.lastName) &&
                Objects.equals(this.email, userSave.email);
    }

    @Override public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    @Override public String toString() {
        return "UserSave{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + '}';
    }
}
