package ru.infoza.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 gerFirstVersionOfPerson() {
        return new PersonV1("John Doe");
    }

    @GetMapping("/v2/person")
    public PersonV2 gerSecondVersionOfPerson() {
        return new PersonV2("John", "Doe");
    }

}
