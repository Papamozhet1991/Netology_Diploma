package skovorodkoartyom.cloud_storage_backend.cloud_storage_backend.utils;

import skovorodkoartyom.cloud_storage_backend.cloud_storage_backend.dto.UserDto;
import skovorodkoartyom.cloud_storage_backend.cloud_storage_backend.entity.UserEntity;

public interface MapperUtils {

    UserEntity toUserEntity(UserDto userDto);

    UserDto toUserDto(UserEntity userEntity);

}