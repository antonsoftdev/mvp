package com.handyman.mvp.controller;

import com.handyman.mvp.dto.UserDtoRequest;
import com.handyman.mvp.dto.UserDtoResponse;
import com.handyman.mvp.model.User;
import com.handyman.mvp.service.LeadService;
import com.handyman.mvp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final LeadService leadService;

    public UserController(UserService userService, LeadService leadService) {
        this.userService = userService;
        this.leadService = leadService;
    }

    @PostMapping("/create")
    @ResponseBody
    public UserDtoResponse setUser(@RequestBody UserDtoRequest userDtoRequest) {
        User user = userService.createUser(userDtoRequest);
        leadService.createLeadByUser(user);
        return userService.convertToDtoResponse(user);
    }

    @GetMapping(params = {"get"})
    public ResponseEntity<UserDtoResponse> getUserById(@RequestParam(value = "id") long id) {
        return new ResponseEntity<>(userService.sendUser(id), HttpStatus.OK);
    }
}
