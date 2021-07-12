package com.example.springsecurityjwtapp.controller;

import com.example.springsecurityjwtapp.dto.UserDto;
import com.example.springsecurityjwtapp.entity.User;
import com.example.springsecurityjwtapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestController {
    private UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){

        User user=userService.findById(id);
        if (user==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDto result=UserDto.fromUser(user);

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
