package com.assessment.damco.api.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Data
public class UserForm {

    @NotBlank(message = "First Name is required")
    private String firstname;
    @NotBlank(message = "SurName is required")
    private String surname;
    @NotNull(message = "DOB is required.")
    private Date dob;
    @NotBlank(message = "Title is required")
    private String title;

}
