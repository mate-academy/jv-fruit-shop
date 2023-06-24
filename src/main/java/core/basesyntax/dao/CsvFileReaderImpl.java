package core.basesyntax.dao;

import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionParserImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final String ERROR_MESSAGE = "Can`t read data from CSV file ";
    private static final int OPERATION_INDEX = 0;
    private FruitTransactionParser parseTransactionService = new FruitTransactionParserImpl();

    @Override
    public String readTransactions(String fromFileName) {
        String transactionsInString = "";
        List<String> transactions = new ArrayList<>();
        try {
            transactions = Files.readAllLines(Path.of(fromFileName));
        } catch (IOException e) {
            throw new RuntimeException(ERROR_MESSAGE + fromFileName, e);
        }
        transactions.remove(OPERATION_INDEX);

        for (String transaction : transactions) {
            transactionsInString += transaction + System.lineSeparator();
        }
        return transactionsInString;
    }
}
