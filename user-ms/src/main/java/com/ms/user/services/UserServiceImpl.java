package com.ms.user.services;

import com.ms.user.mappers.UserMapper;
import com.ms.user.models.dto.request.UserRequestDto;
import com.ms.user.models.dto.response.UserResponse;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserProducer userProducer;
    private final UserMapper mapper;

    @Override
    public UserResponse save(UserRequestDto userRequestDto) {
        log.info("preparing to register the user in the database...");
        var userEntity = this.userRepository.saveOrElseThrow(mapper.toEntity(userRequestDto));
        log.info("User successfully registered.");
        var userResponse = this.mapper.toResponse(userEntity);
        log.info("Starting the process of sending a message to the queue...");
        userProducer.publishMessageEmail(userResponse);
        log.info("Message to queue process completed successfully");
        return userResponse;
    }

}
