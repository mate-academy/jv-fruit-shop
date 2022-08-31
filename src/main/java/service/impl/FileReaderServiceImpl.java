package service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {

    public List<String> getInfoFromFile(File file) {
        try {
            List<String> parsedInfo = Files.readAllLines(file.toPath());
            return parsedInfo;
        } catch (IOException e) {
            throw new RuntimeException(String.format("Can't read from file %s", file), e);
        }
    }
}
