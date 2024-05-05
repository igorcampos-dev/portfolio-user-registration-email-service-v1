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
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;

    @Override
    public UserResponse save(UserRequestDto userRequestDto) {
        var userResponse = this.saveDb(userRequestDto);
        userProducer.publishMessageEmail(userResponse);
        return userResponse;
    }


    private UserResponse saveDb(UserRequestDto userRequestDto){
        var userEntity = userRepository.saveOrElseThrow(UserMapper.dtoToEntity(userRequestDto));
        return UserMapper.entityToResponse(userEntity);
    }
}
