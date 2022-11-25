package com.medipol.h5210017.midterm.service.math.file;

import java.io.File;
import java.io.IOException;

public interface MathFileService {
    File create(String path, String content) throws IOException;
}
