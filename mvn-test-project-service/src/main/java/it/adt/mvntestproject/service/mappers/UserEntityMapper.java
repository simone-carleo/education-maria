package it.adt.mvntestproject.service.mappers;

import it.adt.mvntestproject.dao.entity.User;
import it.adt.mvntestproject.dto.UserDto;
import it.adt.mvntestproject.dto.UserSave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserDto mapUserEntityToUserDto(User user);

    @Mapping(target = "id_user", expression = "java(java.util.UUID.randomUUID().toString())")
    User mapUserSaveToNewUserEntity(UserSave userSave);

    List<UserDto> mapUserEntityListToUserDtoList(List<User> userList);

}
