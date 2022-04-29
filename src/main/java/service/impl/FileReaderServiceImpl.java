package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FilerReaderService;

public class FileReaderServiceImpl implements FilerReaderService {
    @Override
    public List<String> getFileData(String fileName) {
        List<String> fileData;
        try {
            fileData = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cant read from file" + fileName);
        }
        return fileData;
    }
}
