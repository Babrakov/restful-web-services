package ru.infoza.restfulwebservices.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.infoza.restfulwebservices.jpa.PostRepository;
import ru.infoza.restfulwebservices.jpa.UserRepository;
import ru.infoza.restfulwebservices.user.Post;
import ru.infoza.restfulwebservices.user.PostNotFoundException;
import ru.infoza.restfulwebservices.user.User;
import ru.infoza.restfulwebservices.user.UserNotFoundException;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa")
public class UserJpaResource {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());

        entityModel.add(linkTo.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        return user.get().getPosts();

    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users/{userId}/posts/{postId}")
    public EntityModel<Post> getPost(@PathVariable int userId, @PathVariable int postId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("userId: " + userId);
        }

        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()) {
            throw new PostNotFoundException("postId: " + postId);
        }

        EntityModel<Post> entityModel = EntityModel.of(post.get());
//        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
//
//        entityModel.add(linkTo.withRel("all-users"));

        return entityModel;
    }

}
