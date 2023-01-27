package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseTransactionService;
import core.basesyntax.service.ParseTransactionServiceImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String ERROR_MESSAGE = "Can`t read data from CSV file ";
    private static final int OPERATION_INDEX = 0;
    private ParseTransactionService parseTransactionService = new ParseTransactionServiceImpl();

    @Override
    public List<FruitTransaction> readTransactions(String fromFileName) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Path.of(fromFileName));
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + fromFileName, e);
        }
        lines.remove(OPERATION_INDEX);
        return lines.stream()
                .map(line -> parseTransactionService.parseTransaction(line.trim()))
                .collect(Collectors.toList());
    }
}
