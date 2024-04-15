package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public String read(String fileName) {
        try {
            return Files.readString(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
