package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readFromFile(String pathToFile) {
        File file = new File(pathToFile);
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't find or read file: " + pathToFile, e);
        }
    }
}
