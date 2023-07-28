package core.basesyntax.service.impl;

import core.basesyntax.exceptions.FruitTransactionException;
import core.basesyntax.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    public static final int INDEX_OF_START_TRANSACTIONS = 1;

    @Override
    public List<String> readFromFile(String fileName) {
        Path path = Paths.get(fileName);
        System.out.println();
        List<String> strings;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName,e);
        }
        if (strings.size() <= INDEX_OF_START_TRANSACTIONS) {
            throw new FruitTransactionException("File does not contain transactions");
        }
        return strings.subList(INDEX_OF_START_TRANSACTIONS,strings.size());
    }
}
