package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReading implements FileService {

    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(new File(filePath).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + filePath, e);
        }
    }
}
