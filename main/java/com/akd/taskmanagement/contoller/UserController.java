package com.akd.taskmanagement.contoller;

import com.akd.taskmanagement.dto.UserDto;
import com.akd.taskmanagement.entity.AppUser;
import com.akd.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
        public ResponseEntity<UserDto> register(@RequestBody UserDto user) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.register(user));
    }


    //todo: for debugging only
    @GetMapping("")
    public ResponseEntity<List<AppUser>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

}