package it.adt.mvntestproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserDto {

    @JsonProperty("id_user")
    private String id_user;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("email")
    private String email;


    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

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
        UserDto userDto = (UserDto) o;
        return Objects.equals(this.id_user, userDto.id_user) &&
                Objects.equals(this.firstName, userDto.firstName) &&
                Objects.equals(this.lastName, userDto.lastName) &&
                Objects.equals(this.email, userDto.email);
    }

    @Override public int hashCode() {
        return Objects.hash(id_user, firstName, lastName, email);
    }

    @Override public String toString() {
        return "UserDto{" + "id_user='" + id_user + '\'' + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", email='" + email + '\'' + '}';
    }
}
