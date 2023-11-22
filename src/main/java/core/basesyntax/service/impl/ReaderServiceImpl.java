package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String INPUT_FILE_HEADER = "type,fruit,quantity";

    @Override
    public List<String> readFile(String inputFileName) {
        List<String> transactions;
        try {
            transactions = Files.readAllLines(Path.of(inputFileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + inputFileName);
        }
        transactions.remove(INPUT_FILE_HEADER);
        return transactions;
    }
}
