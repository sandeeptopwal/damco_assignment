package com.assessment.damco.api;


import com.assessment.damco.api.form.UserForm;
import com.assessment.damco.api.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserModelBuilder {

    public UserModel buildUserModel(UserForm userForm, UserModel userModel){

        userModel.setFirstname(userForm.getFirstname());
        userModel.setSurname(userForm.getSurname());
        userModel.setDob(userForm.getDob());
        userModel.setTitle(userForm.getTitle());
        return userModel;
    }

}
