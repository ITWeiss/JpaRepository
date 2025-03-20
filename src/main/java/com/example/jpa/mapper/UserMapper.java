package com.example.jpa.mapper;

import com.example.jpa.dto.UserDto;
import com.example.jpa.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
