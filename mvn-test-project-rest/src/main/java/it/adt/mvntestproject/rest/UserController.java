package it.adt.mvntestproject.rest;

import it.adt.mvntestproject.dao.entity.User;
import it.adt.mvntestproject.dto.UserDto;
import it.adt.mvntestproject.dto.UserNameDto;
import it.adt.mvntestproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "api/v1")
public class UserController {
    @Autowired
    private IUserService iUserService;


    @PostMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE})
    public User create(@RequestBody UserDto userDto){
        return this.iUserService.create(userDto);
    }

    @GetMapping(value = "/user/find-all-users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getUsers(){
        return (List<User>) iUserService.getAllUsers();
    }

    @GetMapping(value = "/user/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByEmail(@PathVariable(value = "email", required = true) String email){
        return this.iUserService.getByEmail(email);
    }


    @PatchMapping(value = "/user/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User updateNameOfUserIdentifiedByEmail(@PathVariable(value ="email", required = true) String email,@RequestBody UserNameDto userNameDto){
        return this.iUserService.updateNameOfUserIdentifiedByEmail(email,userNameDto);
    }


    @PutMapping(value = "/user/{email}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public User updateUserIdentifiedByEmail(@PathVariable(value = "email", required = true) String email, @RequestBody UserDto userDto){
        return this.iUserService.updateUser(email, userDto);

    }

/*
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

    */
}
