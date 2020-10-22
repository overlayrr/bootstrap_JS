package com.example.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.example.springboot.web.models.User;
import com.example.springboot.web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/admin")
    public String getUsers(ModelMap model) {
        User thisUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("thisUser", thisUser);
        model.addAttribute("listUsers", userService.getAllUsers());
        model.addAttribute("newUser", new User());
        model.addAttribute("allRoles", userService.getAllRole());
        return "users";
    }

    @PostMapping(path = "/delete")
    public String deleteEmployeeById(@RequestParam(value = "idDelete", required = false) Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @PostMapping(path = "/createUser")
    public String createOrUpdateEmployee(User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping("admin/update")
    public String updateUser(@RequestParam(value = "idEdit", required = false) Long id,
                             @RequestParam(value = "firstNameEdit", required = false) String firstName,
                             @RequestParam(value = "lastNameEdit", required = false) String lastName,
                             @RequestParam(value = "ageEdit", required = false) int age,
                             @RequestParam(value = "emailEdit", required = false) String email,
                             @RequestParam(value = "passwordEdit", required = false) String password,
                             @RequestParam(value = "editRole", required = false) String role) {
        User user = userService.getUserById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        user.setEmail(email);
        user.setRoles(userService.createRole(role));

        if (password == null) {
            user.setPassword(user.getPassword());
        } else {
            user.setPassword(password);
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }


    @RequestMapping(value = "user")
    public String userDataGet(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute(
                "user", userService.getUserIdByLogin(auth.getName()));
        return "userData";
    }

    @GetMapping("login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

}
