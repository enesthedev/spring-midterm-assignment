package com.medipol.h5210017.midterm.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService implements IFileService{
    @Override
    public File create(String path, String content) throws IOException {

        File file = new File(path);

        byte[] contentBytes = content.getBytes();

        if (!file.exists()) {
            boolean isFileCreated = file.createNewFile();
            if (!isFileCreated) {
                throw new IOException("Unable to create file at specified path. It already exists");
            }
        }

        Files.write(Path.of(file.getAbsolutePath()), contentBytes);

        return file;
    }
}
