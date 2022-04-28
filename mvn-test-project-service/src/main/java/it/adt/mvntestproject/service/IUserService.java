package it.adt.mvntestproject.service;

import it.adt.mvntestproject.dao.entity.User;
import it.adt.mvntestproject.dto.UserDto;
import it.adt.mvntestproject.dto.UserNameDto;

import java.util.List;

public interface IUserService {
    User create(UserDto userDto);
    List<User> getAllUsers();
    User getByEmail(String email);
    User updateUser(String email, UserDto userDto);
    User updateNameOfUserIdentifiedByEmail(String email, UserNameDto userNameDto);
}
