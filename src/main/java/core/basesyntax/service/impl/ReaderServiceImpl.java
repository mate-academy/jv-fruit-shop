package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String filename) {
        List<String> fileContent;
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            fileContent = stream.toList();
        } catch (IOException e) {
            throw new RuntimeException("File can't be read.", e);
        }
        return fileContent;
    }
}
