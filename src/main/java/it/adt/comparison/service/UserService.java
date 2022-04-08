package it.adt.comparison.service;

import it.adt.comparison.User;
import it.adt.comparison.dto.UserDto;
import it.adt.comparison.dto.UserNameDto;
import it.adt.comparison.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public User create(UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return this.userRepository.save(user);
    }

    public Iterable<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getByEmail(String email){
        return this.userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public User updateUser(String email, UserDto userDto){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return this.userRepository.save(user);
    }

    public User updateNameOfUserIdentifiedByEmail(String email, UserNameDto userNameDto){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.setFirstName(userNameDto.getFirstName());
        return this.userRepository.save(user);
    }

}
