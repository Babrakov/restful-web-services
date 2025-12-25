package ru.infoza.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.infoza.restfulwebservices.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
