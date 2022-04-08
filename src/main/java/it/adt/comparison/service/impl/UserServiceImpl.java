package it.adt.comparison.service.impl;

import it.adt.comparison.dto.UserDto;
import it.adt.comparison.dto.UserNameDto;
import it.adt.comparison.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    public void create(UserDto userDto){
        //TODO create a User
    }
    public void getAllUsers(){
        //TODO find all created users
    }
    public void getByEmail(String email){
        //TODO get user by email
    }
    public void updateUser(String email, UserDto userDto){
        //TODO update user identified by email
    }
    public void updateNameOfUserIdentifiedByEmail(String email, UserNameDto userNameDto){
        //TODO update name of user identified by email
    }
}
