package com.ms.user.mappers;

import com.ms.user.models.dto.request.UserRequestDto;
import com.ms.user.models.dto.response.UserResponse;
import com.ms.user.models.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract UserResponse toResponse(UserEntity userEntity);
    public abstract UserEntity toEntity(UserRequestDto userResponse);
}
