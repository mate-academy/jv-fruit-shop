package core.basesyntax.impl;

import core.basesyntax.servise.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImplFromCsv implements ReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> readLines;
        Path path = Path.of(filePath);
        try {
            readLines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file "
                    + path.getFileName(), e);
        }
        if (readLines.isEmpty()) {
            throw new RuntimeException("Input file can not be empty: "
                    + path.getFileName());
        }
        return readLines;
    }
}
