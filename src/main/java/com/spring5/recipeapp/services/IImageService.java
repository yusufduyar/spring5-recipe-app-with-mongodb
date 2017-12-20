package com.spring5.recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    void saveImageFile(String recipeId, MultipartFile multipartFile);
}
