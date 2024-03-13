package com.avl.damback.web;

import com.avl.damback.dao.AssetsRepository;
import com.avl.damback.dto.AssetsDto;
import com.avl.damback.entities.Assets;
import com.avl.damback.mappers.AssetsMapper;
import com.avl.damback.mappers.AssetsMapperImpl;
import com.avl.damback.services.FileUploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/assets")
@CrossOrigin(origins = "*")
public class AssetsController {
    @Autowired
    private AssetsRepository assetsRepository;
    @Autowired
    private AssetsMapper assetsMapper = new AssetsMapperImpl();
    @Autowired
    private FileUploaderService fileUploaderService;


     @GetMapping("/all")
    public List<AssetsDto> getAllAssets() {
         return assetsRepository.findAll().stream().map(assetsMapper::toDto).toList();
     }
    @PostMapping()
    public AssetsDto addAsset(@RequestBody AssetsDto assetsDto) {
         Assets assets = assetsMapper.toEntity(assetsDto);
         assets.setCategorieName(assetsDto.getCategorieName());
        return assetsMapper.toDto(assetsRepository.save(assets));
    }
    @PostMapping("/uploadFile/{id}")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable Long id) {

        fileUploaderService.uploadFile(file,id);


        return ResponseEntity.ok(Collections.singletonMap("message","You have successfully uploaded '"+ file.getOriginalFilename()+"' !"));


    }
}
