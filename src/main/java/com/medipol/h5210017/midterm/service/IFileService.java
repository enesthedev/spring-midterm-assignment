package com.medipol.h5210017.midterm.service;

import java.io.File;
import java.io.IOException;

public interface IFileService {
    File create(String path, String content) throws IOException;
}
