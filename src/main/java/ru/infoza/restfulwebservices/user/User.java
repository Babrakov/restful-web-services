package ru.infoza.restfulwebservices.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private LocalDate birthDate;

}
