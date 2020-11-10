package com.example.springboot.web.service;

import com.example.springboot.web.Repository.RoleRepo;
import com.example.springboot.web.Repository.UserRepo;
import com.example.springboot.web.models.Role;
import com.example.springboot.web.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final RoleRepo roleRepo;
    private final UserRepo userRepo;

    public UserService(RoleRepo roleRepo, UserRepo userRepo) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    public void addUser(User user) {
        userRepo.saveAndFlush(user);
    }

    public List<Role> getAllRole() {
        return roleRepo.findAll();
    }

    public User getUserById(long id) {
        return userRepo.getOne(id);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    public void updateUser(User user) {
        userRepo.saveAndFlush(user);
    }

    public Optional<Role> createRole(String name) {
        return roleRepo.findByRole(name);
    }

    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username);
    }

}
