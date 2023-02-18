package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvFileReaderServiceImpl implements FileReaderService {
    private static final int TITLE_LINE_INDEX = 0;

    @Override
    public List<String> readFromFile(String fromFile) {
        File file = new File(fromFile);
        List<String> transactions;
        try {
            transactions = Files.readAllLines(file.toPath());
            transactions.remove(TITLE_LINE_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + file + e);
        }
        return transactions;
    }
}
