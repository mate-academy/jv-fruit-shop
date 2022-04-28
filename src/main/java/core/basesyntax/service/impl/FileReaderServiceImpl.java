package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    public List<String> readWithFile(String fileName) {
        File file = new File(fileName);
        List<String> stringList = null;
        try {
            stringList = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("File does not exist: " + fileName, e);
        }
        return stringList;
    }
}
