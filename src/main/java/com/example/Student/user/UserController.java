package com.example.Student.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

//    this route will list all the user
    @GetMapping
    public List<User> listUser(){
        // will visit this shortly
        return UserRepository.findAll();
    }

    // This will create new user
    @PostMapping
    public User create(@RequestBody User order){
        order.setDateCreated(LocalDate.from(LocalDateTime.now()));
        return User.save(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOrder(@PathVariable Long id){
        Optional<User> order = user = UserRepository.findById(id);
        return order.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notfound().build);
    }

    // This route is used to update user
    @PutMapping("/{id}")
    public ResponseEntity<User> updateOrder(@PathVariable Long id, @RequestBody User UpdateOrder){
        Optional<User> existingOrder = User.findById(id);
        if(existingOrder.isPresent()){
            User CurrentOrder = existingOrder.get();
            currentOrder.setUsername(updateOrder.getUsername());
            currentOrder.setEmail(updateOrder.getEmail());
            currentOrder.setPhoneNumber(updateOrder.getPhoneNumber());
            currentOrder.setStatus(updateOrder.getStatus());
            UserRepository.save(currentOrder);
            retrn ResponseEntity.ok(currentOrder);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    // this route is used to delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        if(UserRepository.existsById(id)){
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
