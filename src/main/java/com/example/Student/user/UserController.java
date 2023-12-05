package com.example.Student.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> listUser(){
        // will visit this shortly
        return UserRepository.findAll();
    }

    @PostMapping
    public User create(@RequestBody User order){
        order.setDateCreated(LocalDateTime.now());
        return User.save(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOrder(@PathVariable Long id){
        Optional<User> order = user = UserRepository.findById(id);
        return order.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notfound().build);
    }
}
