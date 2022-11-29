package com.gientech.study.demo.struct;

import com.gientech.study.demo.dto.UserDto;
import com.gientech.study.demo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserStruct {

    UserStruct INSTANCE = Mappers.getMapper(UserStruct.class);

    UserDto toDto(UserEntity userEntity);

    List<UserDto> toDto(List<UserEntity> userEntities);

    UserEntity toEntity(UserDto userDto);

    List<UserEntity> toEntity(List<UserDto> userDtos);
}
