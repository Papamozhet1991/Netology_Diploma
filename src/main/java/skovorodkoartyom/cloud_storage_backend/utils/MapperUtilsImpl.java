package skovorodkoartyom.cloud_storage_backend.utils;

import skovorodkoartyom.cloud_storage_backend.model.dto.UserDto;
import skovorodkoartyom.cloud_storage_backend.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class MapperUtilsImpl implements MapperUtils {

    @Override
    public UserEntity toUserEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(userDto.getLogin());
        userEntity.setPassword(userDto.getPassword());
        return userEntity;
    }

    @Override
    public UserDto toUserDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setLogin(userEntity.getLogin());
        userDto.setPassword(userEntity.getPassword());
        return userDto;
    }
}