package com.assessment.damco.api.controller;

import com.assessment.damco.api.form.UserForm;
import com.assessment.damco.api.model.UserModel;
import com.assessment.damco.api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserModel> saveUserData(@RequestBody @Valid UserForm userForm){

        return new ResponseEntity<>(userService.createUser(userForm), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserModel>> getAllUserData(){

        return new ResponseEntity<>(userService.getAllUserDetails(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> getUserData(@PathVariable("userId") String userId){

        return new ResponseEntity<>(userService.getUserDetails(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserModel> updateUserData(@PathVariable("userId") String userId,@RequestBody @Valid UserForm userForm){

        return new ResponseEntity<>(userService.updateUser(userId,userForm), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUserData(@PathVariable("userId") String userId){

        return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }

}
