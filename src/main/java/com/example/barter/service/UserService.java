package com.example.barter.service;

import com.example.barter.dto.entity.UserEntity;
import com.example.barter.dto.input.SaveUserInput;
import com.example.barter.dto.response.UserResponse;
import com.example.barter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    final UserRepository userRepository;

    @Autowired
    public UserService(final UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }


    public Mono<UserResponse> save(SaveUserInput saveUserInput)
    {
      return   userRepository.save(UserEntity.fromSaveUserInput(saveUserInput))
                .map(UserResponse::fromUserEntity);
    }


    public Mono<UserResponse> get(String id)
    {
         return    userRepository.findById(id)
                    .map(UserResponse::fromUserEntity);
    }


    public Flux<UserResponse> update(SaveUserInput saveUserInput)
    {
        return userRepository.update(saveUserInput.getId(),saveUserInput.getName(),saveUserInput.getAge(),saveUserInput.getProfileImage())
                .map(UserResponse::fromUserEntity);
    }

    public Mono<Void> delete(String id)
    {
        return userRepository.deleteById(id);
    }
}
