package it.adt.comparison.service;

import it.adt.comparison.User;
import it.adt.comparison.dto.UserDto;
import it.adt.comparison.dto.UserNameDto;

import java.util.List;

public interface IUserService {
    User create(UserDto userDto);
    List<User> getAllUsers();
    User getByEmail(String email);
    User updateUser(String email, UserDto userDto);
    User updateNameOfUserIdentifiedByEmail(String email, UserNameDto userNameDto);
}
