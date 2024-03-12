package com.avl.damback.web;

import com.avl.damback.dao.AssetsRepository;
import com.avl.damback.dto.AssetsDto;
import com.avl.damback.entities.Assets;
import com.avl.damback.mappers.AssetsMapper;
import com.avl.damback.mappers.AssetsMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assets")
@CrossOrigin(origins = "*")
public class AssetsController {
    @Autowired
    private AssetsRepository assetsRepository;
    @Autowired
    private AssetsMapper assetsMapper = new AssetsMapperImpl();


     @GetMapping("/all")
    public List<AssetsDto> getAllAssets() {
         return assetsRepository.findAll().stream().map(assetsMapper::toDto).toList();
     }
    @PostMapping()
    public AssetsDto addAsset(@RequestBody AssetsDto assetsDto) {
         Assets assets = assetsMapper.toEntity(assetsDto);
         assets.setFileUrl("/tmp/files/" + assets.getFileName()+ "." + assets.getFileExtension());
         assets.setFileSize(assets.getFileUrl().length());
        return assetsMapper.toDto(assetsRepository.save(assets));
    }
}
