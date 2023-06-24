package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String FILE_NAME = "src/main/resources/InputInfo.csv";
    private static final String FIRST_LINE = "type";
    private final TransactionService transactionService;

    public ReaderServiceImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public void readInfoFromFile() {
        List<String> fruitInfo;
        try {
            fruitInfo = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + FILE_NAME, e);
        }
        fruitInfo.stream().filter(s -> !s.startsWith(FIRST_LINE))
                .forEach(transactionService::registerNewTransaction);
    }
}
