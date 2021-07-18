package com.assessment.damco.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "user")
@Data
public class UserModel {

    @Id
    String id;

    private String firstname;
    private String surname;
    private Date dob;
    private String title;
}
