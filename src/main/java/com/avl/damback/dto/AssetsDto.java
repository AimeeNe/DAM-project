package com.avl.damback.dto;

import lombok.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.avl.damback.entities.Assets}
 */
@Value
public class AssetsDto implements Serializable {
    Long id;
    String fileName;
    String fileType;
    String description;
    LocalDateTime createdAt;
    Integer fileSize;
    String fileUrl;
    String fileExtension;
    String categorieName;
    MultipartFile fileToUpload;
}