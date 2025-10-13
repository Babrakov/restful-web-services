package ru.infoza.restfulwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean filtering(){
        return new SomeBean("1value1","1value2","1value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return List.of(
                new SomeBean("1value1","1value2","1value3"),
                new SomeBean("2value1","2value2","2value3")
        );
    }

}
