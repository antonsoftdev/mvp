package com.handyman.mvp.service;

import com.handyman.mvp.dto.UserDtoRequest;
import com.handyman.mvp.dto.UserDtoResponse;
import com.handyman.mvp.model.User;
import com.handyman.mvp.repositiry.UserRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        return getUserById(id);
    }

    public UserDtoResponse sendUser(Long id) {
        //return convertToDtoResponse(userRepository.getReferenceById(id));
        return convertToDtoResponse(getUserById(id));
    }

    public User createUser(UserDtoRequest userDtoRequest) {
        LOG.info("Добавлен пользователь: {} {}.", userDtoRequest.getFirstName(), userDtoRequest.getLastName());
        User user = convertToEntity(userDtoRequest);
        userRepository.save(user);
        return user;
    }

    public void delete(UserDtoRequest userDtoRequest) {
        LOG.info("Пользователь {} {} был удален.", userDtoRequest.getFirstName(), userDtoRequest.getLastName());
        userRepository.delete(convertToEntity(userDtoRequest));
    }

    private User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public UserDtoResponse convertToDtoResponse(User user) {
        return modelMapper.map(user, UserDtoResponse.class);
    }

    public UserDtoRequest convertToDtoRequest(User user) {
        return modelMapper.map(user, UserDtoRequest.class);
    }

    public User convertToEntity(UserDtoResponse userDtoResponse) {
        return modelMapper.map(userDtoResponse, User.class);
    }

    public User convertToEntity(UserDtoRequest userDtoRequest) {
        return modelMapper.map(userDtoRequest, User.class);
    }

}
