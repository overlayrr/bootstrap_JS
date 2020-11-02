package com.example.springboot.web.controller;

import com.example.springboot.web.models.Role;
import com.example.springboot.web.models.User;
import com.example.springboot.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RestControllers {

    private UserService userService;
    @Autowired
    public void AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public User userInfo() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/allUsers")
    public List<User> allUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/allRoles")
    public List<Role> allRoles() {
        return userService.getAllRole();
    }

    @GetMapping("/newUser")
    public User createUser() {
        return new User();
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
       if (user.getAge() == null){
           user.setAge(0);
       }
        userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/editUser")
    public ResponseEntity<?> editUser(@RequestBody User user) {
            userService.updateUser(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }


    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable(name = "id") Long id) {
        return userService.getUserById(id);
    }

}

