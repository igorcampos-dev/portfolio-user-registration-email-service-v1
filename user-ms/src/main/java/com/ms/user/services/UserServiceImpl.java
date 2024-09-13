package com.ms.user.services;

import com.ms.user.mapper.UserMapper;
import com.ms.user.models.dto.request.UserRequestDto;
import com.ms.user.models.dto.response.UserResponse;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;
    private final UserMapper mapper;

    @Override
    public UserResponse save(UserRequestDto userRequestDto) {
        var userEntity = this.userRepository.saveOrElseThrow(mapper.toEntity(userRequestDto));
        var userResponse = this.mapper.toResponse(userEntity);
        userProducer.publishMessageEmail(userResponse);
        return userResponse;
    }

}
