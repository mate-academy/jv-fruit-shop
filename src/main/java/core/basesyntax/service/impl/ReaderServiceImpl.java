package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String FILE_READ_ERROR_MESSAGE = "Can't read from file";
    private static final String NO_TRANSACTIONS_MESSAGE = "File does not contain transactions";

    @Override
    public List<String> readFromFile(String fileName) {
        try {
            List<String> strings = Files.readAllLines(Path.of(fileName));
            if (strings.size() <= 1) {
                throw new RuntimeException(NO_TRANSACTIONS_MESSAGE);
            }
            return strings.subList(1, strings.size());
        } catch (IOException e) {
            throw new RuntimeException(FILE_READ_ERROR_MESSAGE + " " + fileName, e);
        }
    }
}
