package com.assessment.damco.api.service;

import com.assessment.damco.api.form.UserForm;
import com.assessment.damco.api.model.UserModel;

import java.util.List;

public interface UserService {

    UserModel createUser(UserForm userForm);

    UserModel updateUser(String id,UserForm userForm);

    UserModel getUserDetails(String id);

    List<UserModel> getAllUserDetails();

    Boolean deleteUser(String id);


}
