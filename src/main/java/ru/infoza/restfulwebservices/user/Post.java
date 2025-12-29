package ru.infoza.restfulwebservices.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min = 10)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
