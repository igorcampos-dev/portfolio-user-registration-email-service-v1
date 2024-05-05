package com.ms.user.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.user.models.dto.request.UserRequestDto;
import com.ms.user.models.dto.response.UserResponse;
import com.ms.user.models.entity.UserEntity;

public class UserMapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static UserResponse entityToResponse(UserEntity userEntity){
        return mapper.convertValue(userEntity, UserResponse.class);
    }

    public static UserEntity dtoToEntity(UserRequestDto userRequestDto){
        return mapper.convertValue(userRequestDto, UserEntity.class);
    }
}
