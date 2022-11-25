package com.medipol.h5210017.midterm.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {
    public static File create(String path) throws IOException {
        File file = new File(path); // Create a temporary file

        if (!file.exists()) {
            boolean isFileCreated = file.createNewFile(); // Turn into real file
            if (!isFileCreated) {
                throw new IOException("Unable to create file at specified path. It already exists"); // Possibly causes: chmod x+a
            }
        }

        return file;
    }

    public static Path write(File file, String content) throws IOException, IllegalArgumentException, UnsupportedOperationException {
        String absoluteFilePath = file.getAbsolutePath(); // Get the absolute path /src/main/...
        Path filePath = Path.of(absoluteFilePath); // Turn String to Path element

        byte[] fileContentBytes = content.getBytes();

        return Files.write(filePath, fileContentBytes);
    }
}
