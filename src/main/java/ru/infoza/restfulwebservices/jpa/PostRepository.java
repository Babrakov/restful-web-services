package ru.infoza.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.infoza.restfulwebservices.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
