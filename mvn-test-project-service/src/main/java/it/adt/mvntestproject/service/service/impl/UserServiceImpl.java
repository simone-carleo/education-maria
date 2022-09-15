package it.adt.mvntestproject.service.service.impl;


import it.adt.mvntestproject.common.exception.EntityNotFoundException;
import it.adt.mvntestproject.dao.entity.User;
import it.adt.mvntestproject.dao.repository.PurchaseRepository;
import it.adt.mvntestproject.dto.UserDto;
import it.adt.mvntestproject.dto.UserNameDto;
import it.adt.mvntestproject.dao.repository.UserRepository;
import it.adt.mvntestproject.dto.UserSave;
import it.adt.mvntestproject.service.service.IUserService;
import it.adt.mvntestproject.service.mappers.UserEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;


import java.util.*;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Autowired
    private PurchaseRepository purchaseRepository;


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserDto create(UserSave userSave){
//        User user = new User();
//        user.setEmail(userDto.getEmail());
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        return this.userRepository.save(user);
        User user = userEntityMapper.mapUserSaveToNewUserEntity(userSave);
        User savedEntity = userRepository.save(user);
        return userEntityMapper.mapUserEntityToUserDto(savedEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<UserDto> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return userEntityMapper.mapUserEntityListToUserDtoList(userList);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User getByEmail(String email){
        return this.userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserDto updateUser(String email, UserDto userDto){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        User savedEntity = userRepository.save(user);
        return userEntityMapper.mapUserEntityToUserDto(savedEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserDto updateNameOfUserIdentifiedByEmail(String email, UserNameDto userNameDto){
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        user.setFirstName(userNameDto.getFirstName());
        User savedEntity = userRepository.save(user);
        return userEntityMapper.mapUserEntityToUserDto(savedEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true, rollbackFor = Exception.class)
    public User findByUserId(String userId) throws EntityNotFoundException {
        Optional<User> optionalUser = userRepository.findByIdUser(userId);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else
            throw new EntityNotFoundException(String.format("User with id: %s not found", userId));
    }

}
