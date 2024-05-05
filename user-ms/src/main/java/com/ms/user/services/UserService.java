package com.ms.user.services;

import com.ms.user.models.dto.request.UserRequestDto;
import com.ms.user.models.dto.response.UserResponse;

public interface UserService {
    UserResponse save(UserRequestDto userRequestDto);
}
