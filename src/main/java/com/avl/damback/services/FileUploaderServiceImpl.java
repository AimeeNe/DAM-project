package com.avl.damback.services;

import com.avl.damback.dao.AssetsRepository;
import com.avl.damback.entities.Assets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Service
@Transactional
@Slf4j
public class FileUploaderServiceImpl implements FileUploaderService {
    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
    @Autowired
    private AssetsRepository assetsRepository;
    @Override
    public void uploadFile(MultipartFile file, Long assetsId) {
        Assets assets = assetsRepository.findById(assetsId).orElseThrow(() -> new RuntimeException("Asset not found"));
        try {
            String filename = assets.getFileName() + "." + assets.getFileExtension();

            log.info("upload file : " + filename);

            String path = uploadDir + File.separator + StringUtils.cleanPath(filename);
            Path copyLocation = Paths
                    .get(path);
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            assets.setFileUrl(path);
            assets.setFileSize(assets.getFileUrl().length());


            log.info("file added to : " + path);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
                    + ". Please try again!");
        }
    }
}
