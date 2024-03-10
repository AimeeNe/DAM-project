package com.avl.damback.web;

import com.avl.damback.dao.UserRepository;
import com.avl.damback.entities.Categorie;
import com.avl.damback.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("message")
    public String getMessage(){
        return "Message";
    }
    @GetMapping("test")
    public String getTest(){
        return "Test";
    }
    @GetMapping("getAll")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    @GetMapping("/{idCat}")
    public User getOneUser(@PathVariable("idCat") Long id){
        return userRepository.findById(id).get();
    }
}
