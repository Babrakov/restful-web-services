package ru.infoza.restful_web_services.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class User {

    private Integer id;
    private String name;
    private LocalDate birthDate;

}
