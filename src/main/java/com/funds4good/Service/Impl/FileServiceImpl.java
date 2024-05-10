package com.funds4good.Service.Impl;

import com.funds4good.Service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    public static final String PATH = "./target/classes/static/Resources";
    @Override
    public String uploadImage(MultipartFile file, String key) {
        String filename = file.getOriginalFilename();
        if (filename == null) {
            throw new IllegalArgumentException("Invalid file name");
        }
        String randomID = UUID.randomUUID().toString();
        String newFileName = randomID.concat(filename.substring(filename.lastIndexOf(".")));
        String filepath = PATH + File.separator + newFileName;
        File newFile = new File(filepath).getParentFile();
        if (!newFile.exists() && !newFile.mkdirs()) {
            throw new RuntimeException("Failed to create directory: " + newFile);
        }
        try {
            Files.copy(file.getInputStream(), Paths.get(filepath));
            return "/file/Resources/" + newFileName;
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file: " + newFileName, e);
        }
    }

    public static boolean fileValidation(MultipartFile[] media) throws NullPointerException {
        for (MultipartFile image : media) {
            if (!image.getContentType().equals("image/png") && !image.getContentType().equals("image/jpg") && !image.getContentType().equals("image/jpeg") && !image.getContentType().equals("image/webp")) {
                return true;
            }
        }
        return false;
    }
}