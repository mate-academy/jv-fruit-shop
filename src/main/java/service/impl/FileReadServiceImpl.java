package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import service.FileReadService;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public String readFromFile(Path path) {
        try {
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file with name " + path.getFileName(), e);
        }
    }
}
