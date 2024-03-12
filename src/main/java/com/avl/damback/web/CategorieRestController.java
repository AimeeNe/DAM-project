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




}
