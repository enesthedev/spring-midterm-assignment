package com.medipol.h5210017.midterm.service.file;

import com.medipol.h5210017.midterm.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileServiceImpl implements FileService {

    @Override
    public File create(String path, String content) throws IOException {

        /*  I used the file creation and data writing functions in the FileUtil static class.
         *  I could create these functions here as well, but I realized that they can be used
         *  by other services and not really a service task. */

        File file = FileUtil.create(path);
        FileUtil.write(file, content);

        return file;
    }
}
