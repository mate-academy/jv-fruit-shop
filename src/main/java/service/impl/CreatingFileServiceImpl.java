package service.impl;

import java.io.File;
import java.io.IOException;
import service.CreatingFileService;

public class CreatingFileServiceImpl implements CreatingFileService {
    @Override
    public void createFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file by path: " + path, e);
        }
    }
}
