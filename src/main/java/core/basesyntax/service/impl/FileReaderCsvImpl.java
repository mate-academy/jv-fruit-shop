package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReaderCsvImpl implements Reader {
    private static final int COLUMN_NAMES_INDEX = 0;

    @Override
    public List<String> read(String fileName) {
        List<String> transactions = new ArrayList<>();
        try {
            transactions = Files.readAllLines(Path.of(fileName));
            transactions.remove(COLUMN_NAMES_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + fileName);
        }
        return transactions;
    }
}
