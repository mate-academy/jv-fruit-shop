package core.basesyntax.servise.impl;

import core.basesyntax.servise.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CsvFileReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFromFile(String pathInnFile) {
        try (Stream<String> streamFromFile = Files.lines(Paths.get(pathInnFile))) {
            return streamFromFile.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + pathInnFile, e);
        }
    }
}
