package core.basesyntax.service.impl;

import core.basesyntax.exceptions.FruitTransactionException;
import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int INDEX_OF_START_TRANSACTIONS = 1;

    @Override
    public List<String> readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        List<String> strings;
        try (Stream<String> lines = Files.lines(path)) {
            strings = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName,e);
        }
        if (strings.size() <= INDEX_OF_START_TRANSACTIONS) {
            throw new FruitTransactionException("File does not contain transactions");
        }
        return strings.subList(INDEX_OF_START_TRANSACTIONS,strings.size());
    }
}
