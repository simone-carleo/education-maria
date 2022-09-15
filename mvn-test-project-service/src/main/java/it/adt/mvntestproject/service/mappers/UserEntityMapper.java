package it.adt.mvntestproject.service.mappers;

import it.adt.mvntestproject.dao.entity.User;
import it.adt.mvntestproject.dto.UserDto;
import it.adt.mvntestproject.dto.UserSave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    @Mapping(source = "idUser", target = "id_user")
    UserDto mapUserEntityToUserDto(User user);

    @Mapping(target = "idUser", expression = "java(java.util.UUID.randomUUID().toString())")
    User mapUserSaveToNewUserEntity(UserSave userSave);

    @Mapping(source = "idUser", target = "id_user")
    List<UserDto> mapUserEntityListToUserDtoList(List<User> userList);

}
