package com.avl.damback.web;

import com.avl.damback.dao.AssetsRepository;
import com.avl.damback.entities.Assets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Assets")
public class AssetsController {
    @Autowired
    private AssetsRepository assetsRepository;

    @GetMapping("message")
    public String getMessage(){
        return "Message";
    }
    @GetMapping("test")
    public String getTest(){
        return "Test";
    }
    @GetMapping("getAll")
    public List<Assets> getAllAssets(){
        return assetsRepository.findAll();
    }
    @GetMapping("/{idCat}")
    public Assets getOneAssets(@PathVariable("idCat") Long id){
        return assetsRepository.findById(id).get();
    }

}
