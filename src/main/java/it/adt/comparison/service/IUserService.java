package it.adt.comparison.service;

import it.adt.comparison.dto.UserDto;
import it.adt.comparison.dto.UserNameDto;

public interface IUserService {
    void create(UserDto userDto);
    void getAllUsers();
    void getByEmail(String email);
    void updateUser(String email, UserDto userDto);
    void updateNameOfUserIdentifiedByEmail(String email, UserNameDto userNameDto);
}
