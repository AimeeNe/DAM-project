package com.avl.damback.services;

import com.avl.damback.entities.Assets;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploaderService {
    void uploadFile(MultipartFile file, Long assetsId);
}
