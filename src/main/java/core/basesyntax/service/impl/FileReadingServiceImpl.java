package core.basesyntax.service.impl;

import core.basesyntax.service.FileReadingService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReadingServiceImpl implements FileReadingService {
    @Override
    public List<String> readFile(String fileName) {
        List<String> readInfo;
        try {
            readInfo = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file" + fileName);
        }
        return readInfo;
    }
}
