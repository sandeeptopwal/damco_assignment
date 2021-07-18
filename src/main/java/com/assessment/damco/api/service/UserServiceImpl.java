package com.assessment.damco.api.service;

import com.assessment.damco.api.UserModelBuilder;
import com.assessment.damco.api.exception.AppException;
import com.assessment.damco.api.form.UserForm;
import com.assessment.damco.api.model.UserModel;
import com.assessment.damco.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService{

    private final UserRepository userRepository;
    private final UserModelBuilder userModelBuilder;

    @Override
    public UserModel createUser(UserForm userForm) {

        return userRepository.save(userModelBuilder.buildUserModel(userForm,new UserModel()));
    }

    @Override
    public UserModel updateUser(String id, UserForm userForm) {
        UserModel savedUserData = userRepository.findById(id).orElseThrow(() -> new AppException("User not found.", HttpStatus.NOT_FOUND));

        return userRepository.save(userModelBuilder.buildUserModel(userForm,savedUserData));
    }

    @Override
    public UserModel getUserDetails(String id) {

       return userRepository.findById(id).orElseThrow(() -> new AppException("User not found.", HttpStatus.NOT_FOUND));
    }

    @Override
    public List<UserModel> getAllUserDetails() {
        return userRepository.findAll();
    }

    @Override
    public Boolean deleteUser(String id) {
       try {
           userRepository.deleteById(id);
       }catch (Exception e){
           throw new AppException(e.getMessage(),HttpStatus.NOT_FOUND);
       }
        return true;
    }
}
