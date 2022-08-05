package com.blogApp.blog.services.impl;

import com.blogApp.blog.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        //File name
        String name = file.getOriginalFilename();
        //abc.png

        //random name generate file
        String randomId = UUID.randomUUID().toString();
        String filename1 = randomId.concat(name.substring(name.lastIndexOf(".")));

        //Full path
        String filePath = path + File.separator + filename1;

        //create folder if not created
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //File copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return filename1;
    }

    @Override
    public InputStream getResource(String path, String filename) throws FileNotFoundException {
        String fullPath = path + File.separator + filename;
        InputStream is = new FileInputStream(fullPath);

        //db logic to return inputstream
        return is;
    }
}
