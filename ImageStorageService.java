package com.example.practice7.services;

import com.sun.source.tree.TryTree;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.UUID;

import static org.apache.commons.io.FilenameUtils.*;
@Service
public class ImageStorageService {
    /*private final Path storageFolder = Paths.get("This PC\\ Downloads\\ Upload");

    public ImageStorageService(){
        try{
            Files.createDirectories(storageFolder);
        }
        catch (IOException exception){
            throw new RuntimeException("Cannot initialize storage", exception);
        }
    }

    private boolean isImageFile (MultipartFile file){
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        return Arrays.asList(new String[] {"png", "jpg", "jpeg", "bmp"})
                .contains(fileExtension.trim().toLowerCase());
    }
     */

    /*
    public String storeFile (MultipartFile file) {
        try{
            if(file.isEmpty()){
                throw new RuntimeException("Failed to store empty file");
            }
            if(!isImageFile(file)){
                throw new RuntimeException("You can only upload image files");
            }
            float fileSizeInMegabytes = file.getSize()/1_000_000.0f;
            if (fileSizeInMegabytes > 5.0f){
                throw new RuntimeException("File must be <= 5mbs");
            }
            String fileExtensions = FilenameUtils.getExtension(file.getOriginalFilename());
            String generateFileName = UUID.randomUUID().toString().replace("-", "");
            generateFileName = generateFileName + '.' +fileExtensions;

            Path destinationFilePath = this.storageFolder.resolve(Paths.get(generateFileName))
                    .normalize().toAbsolutePath();
            if(!destinationFilePath.getParent().equals(this.storageFolder.toAbsolutePath())){
                throw new RuntimeException("Cannot store file outside current directory");
            }
            try (InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream,destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            } return generateFileName;
        }
        catch (IOException exception){
            throw new RuntimeException("Failed to store file", exception);
    }
    */
    private final Path storageFolder = Paths.get("This PC \\ Downloads \\ Uploads");

    public ImageStorageService (){
        try{
            Files.createDirectories(storageFolder);
        }
        catch (IOException exception){
            throw new RuntimeException("Cannot create directory", exception);
        }
    }
    private boolean isImageFile (MultipartFile file){
        try{
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
            return Arrays.asList(new String[] {"jpg", "jpeg", "png", "bmp"}).contains(fileExtension.trim().toLowerCase());
        }
        catch (Exception exception){
            throw new RuntimeException("", exception);
        }
    }

    public String storeFile (MultipartFile file) {
        try{
            if(file.isEmpty()){
                throw new RuntimeException("Cannot store empty file");
            }
            if(!isImageFile(file)){
                throw new RuntimeException("Cannot store not image file");
            }
            String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename())  ;
            String generatedFileName = UUID.randomUUID().toString().replace("-","");
            generatedFileName = generatedFileName + "." + fileExtension;

            Path destinationPath = this.storageFolder.resolve(Paths.get(generatedFileName)).normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()){
                Files.copy(inputStream, destinationPath, StandardCopyOption.REPLACE_EXISTING    );
            } return generatedFileName;
        }
        catch (IOException exception){
            throw new RuntimeException("Failed to store file");
        }
    }
}
