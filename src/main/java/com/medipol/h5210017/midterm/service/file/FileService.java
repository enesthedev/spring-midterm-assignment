package com.medipol.h5210017.midterm.service.file;

import java.io.File;
import java.io.IOException;

public interface FileService {
    File create(String path, String content) throws IOException;
}
