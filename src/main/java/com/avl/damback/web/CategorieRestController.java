package com.avl.damback.web;

import com.avl.damback.dao.CategorieRepository;
import com.avl.damback.entities.Categorie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieRestController {
    @Autowired
    private CategorieRepository categorieRepository;



    @GetMapping("message")
    public String getMessage(){
        return "Message";
    }
    @GetMapping("test")
    public String getTest(){
        return "Test";
    }
    @GetMapping("getAll")
    public List<Categorie> getAllCategories(){
        return categorieRepository.findAll();
    }
    @GetMapping("/{idCat}")
    public Categorie getOneCategorie(@PathVariable("idCat") Long id){
        return categorieRepository.findById(id).get();
    }
}
