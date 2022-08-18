package core.basesyntax.service.csvfileservice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String pathToFile) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file" + pathToFile, e);
        }
        return lines;
    }
}
