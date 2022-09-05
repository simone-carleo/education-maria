package it.adt.mvntestproject.service.service.impl;

import it.adt.mvntestproject.dao.entity.Purchase;
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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
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

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User findByUserId(String userId) {
        Optional<User> optionalUser = userRepository.findById(new Long(userId));
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else
            throw new EntityNotFoundException(String.format("User with id: %s not found", userId));
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    @Scheduled(cron = "${my-properties.cron.expression}")
    public void cronTask() throws ParseException {

//        List<Purchase> purchases = purchaseService.getPurchases();
//        purchases.stream().forEach(this::printPurchase);  //CORRETTO E FUNZIONANTE


//        purchases.stream().forEach(purchase -> System.out.println(purchase.toString()));

//        Map<String, List<PurchaseDto>> purchaseList = getAllUsers().stream()
//                .collect(Collectors.toMap(User::getFirstName, User::getPurchases));  //CORRETTO E FUNZIONANTE
//
//        purchaseList.keySet().stream().forEach(k -> printPurchases(purchaseList.get(k)));

//        String purchaseList = getAllUsers().stream()
//                .collect(mapping(User::getPurchases, toList())).toString();

        System.out.println("Java cron job expression: " + OffsetDateTime.now());
        List<Purchase> purchaseList = purchaseRepository.findAll();
        //purchaseList.keySet().stream().forEach(k -> printPurchases(purchaseList.get(k)));
        purchaseList.stream().forEach(this::printPurchase);
        printNewPurchases();
    }

    private void printPurchase(Purchase purchase){
        System.out.println(String.format("utente: %s %s \t prodotto: %s \t prezzo: %s \t dataAcquisto: %s \t codScontrino: %s",
                purchase.getFirstName(), purchase.getLastName(),
                purchase.getProductName(), purchase.getPurchasePrice()+ "", purchase.getPurchaseDate()+ "", purchase.getReceiptCode()));
    }

//    private void printPurchases(List<Purchase> purchases){
//        purchases.stream().forEach(this::printPurchase);
//
//    }

    private void printNewPurchases() throws ParseException {
        String dateTime = "2022-07-22 17:35:0";
        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Purchase purchase1 = new Purchase();
        purchase1.setFirstName("John");
        purchase1.setLastName("Lenon");
        purchase1.setProductName("Fusilli");
        purchase1.setPurchasePrice(6.6);
        purchase1.setPurchaseDate(dateParser.parse(dateTime));
        purchase1.setReceiptCode("NA-6RTGQ9531");
        Purchase purchase2 = new Purchase();
        purchase2.setFirstName("Tam");
        purchase2.setLastName("Fox");
        purchase2.setProductName("Spaghetti");
        purchase2.setPurchasePrice(5.4);
        purchase2.setPurchaseDate(dateParser.parse(dateTime));
        purchase2.setReceiptCode("NA-6RTGQ9531");
        System.out.println(String.format("utente: %s %s \t prodotto: %s \t prezzo: %s \t dataAcquisto: %s \t codScontrino: %s",
                purchase1.getFirstName(), purchase1.getLastName(),
                purchase1.getProductName(), purchase1.getPurchasePrice()+ "", purchase1.getPurchaseDate()+ "", purchase1.getReceiptCode()));
        System.out.println(String.format("utente: %s %s \t prodotto: %s \t prezzo: %s \t dataAcquisto: %s \t codScontrino: %s",
                purchase2.getFirstName(), purchase2.getLastName(),
                purchase2.getProductName(), purchase2.getPurchasePrice()+ "", purchase2.getPurchaseDate()+ "", purchase2.getReceiptCode()));
    }

}
