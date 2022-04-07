package it.adt.comparison.controller;


import it.adt.comparison.User;
import it.adt.comparison.dto.UserDto;
import it.adt.comparison.dto.UserNameDto;
import it.adt.comparison.repository.UserRepository;
import it.adt.comparison.service.UserService;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value= "api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/user", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User create(@RequestBody UserDto userDto){
        return this.userService.create(userDto);
    }

    @GetMapping(value = "/user/find-all-users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getUsers(){
        List <User> users = userRepository.findAll();
        return users;
    }

    @GetMapping(value = "/user/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User getUserByEmail(@PathVariable(value = "email", required = true) String email){
        return this.userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PatchMapping(value = "/user/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public User updateNameOfUserIdentifiedByEmail(@PathVariable(value ="email", required = true) String email,@RequestBody UserNameDto userNameDto){
        return this.userService.updateNameOfUserIdentifiedByEmail(email,userNameDto);
    }


    @PutMapping(value = "/user/{email}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public User updateUserIdentifiedByEmail(@PathVariable(value = "email", required = true) String email, @RequestBody UserDto userDto){
        return this.userService.updateUser(email, userDto);

    }

}
