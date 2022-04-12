package it.adt.comparison.controller;


import it.adt.comparison.User;
import it.adt.comparison.dto.UserDto;
import it.adt.comparison.dto.UserNameDto;
import it.adt.comparison.service.IUserService;
import it.adt.comparison.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value= "api/v1")
public class UserController {

    @Autowired
    private IUserService iUserService;

/*
    @PostMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User create(@RequestBody UserDto userDto){
        return this.userService.create(userDto);
    }

    @GetMapping(value = "/user/find-all-users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Iterable<User> getUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping(value = "/user/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByEmail(@PathVariable(value = "email", required = true) String email){
        return this.userService.getByEmail(email);
    }


    @PatchMapping(value = "/user/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User updateNameOfUserIdentifiedByEmail(@PathVariable(value ="email", required = true) String email,@RequestBody UserNameDto userNameDto){
        return this.userService.updateNameOfUserIdentifiedByEmail(email,userNameDto);
    }


    @PutMapping(value = "/user/{email}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public User updateUserIdentifiedByEmail(@PathVariable(value = "email", required = true) String email, @RequestBody UserDto userDto){
        return this.userService.updateUser(email, userDto);

    }
*/

    @PostMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void create(@RequestBody UserDto userDto){
        System.out.println("null");
    }

    @GetMapping(value = "/user/find-all-users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void getUsers(){
        List<User> users = new ArrayList();
        System.out.println(users);
    }

    @GetMapping(value = "/user/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void getByEmail(@PathVariable(value = "email", required = true) String email){
        System.out.println("null");
    }

    @PatchMapping(value = "/user/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void updateNameOfUserIdentifiedByEmail(@PathVariable(value ="email", required = true) String email,@RequestBody UserNameDto userNameDto){
        System.out.println("null");
    }

    @PutMapping(value = "/user/{email}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public void updateUser(@PathVariable(value = "email", required = true) String email, @RequestBody UserDto userDto){
        System.out.println("null");
    }
}
