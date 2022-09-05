package it.adt.mvntestproject.service.service;

import it.adt.mvntestproject.dao.entity.User;
import it.adt.mvntestproject.dto.UserDto;
import it.adt.mvntestproject.dto.UserNameDto;
import it.adt.mvntestproject.dto.UserSave;

import java.util.List;

public interface IUserService {
    UserDto create(UserSave userSave);
    List<UserDto> getAllUsers();
    User getByEmail(String email);
    UserDto updateUser(String email, UserDto userDto);
    UserDto updateNameOfUserIdentifiedByEmail(String email, UserNameDto userNameDto);
    User findByUserId(String userId);
}
