package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFrom(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't read file by path: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read lines from the file.", e);
        }
    }
}
