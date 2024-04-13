package core.basesyntax.servise.impl;

import core.basesyntax.servise.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFileReaderServiceImpl implements ReaderService {
    public static final String FILE_PATH = "src/main/resources/file.txt";

    @Override
    public List<String> readFromFile() {
        try (Stream<String> streamFromFile = Files.lines(Paths.get(FILE_PATH))) {
            return streamFromFile.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + FILE_PATH, e);
        }
    }
}
