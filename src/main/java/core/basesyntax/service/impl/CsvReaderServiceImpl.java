package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CsvReaderServiceImpl implements ReaderService {
    @Override
    public List<String> read(String fileName) {
        List<String> listOfLines = new ArrayList<>();
        Path path = Paths.get(fileName);
        try (Stream<String> stream = Files.lines(path).skip(1)) {
            stream.forEach(listOfLines::add);
        } catch (IOException e) {
            throw new RuntimeException("Some problems with file reading: " + e);
        }
        return listOfLines;
    }
}
