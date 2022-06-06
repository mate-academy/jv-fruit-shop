package core.basesyntax.service;

import core.basesyntax.exception.TransactionParsingStringException;
import core.basesyntax.model.ProductTransaction;
import core.basesyntax.model.Setting;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Queue;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public Queue<ProductTransaction> read(Path fileName) {
        Queue<ProductTransaction> productTransactions = new LinkedList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(fileName.toString()))) {
            int lineCount = 0;
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (lineCount++ == 0 && Setting.HEADER_FILE_INPUT.equalsIgnoreCase(line)) {
                    continue;
                }
                productTransactions.add(new ReaderServiceImpl().convertStringToTransaction(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(
                    String.format("Error read data from file '%s'", fileName), e);
        }
        return productTransactions;
    }

    private ProductTransaction convertStringToTransaction(String line) {
        String[] partLine = line.split(Setting.FIELDS_DELIMITER_IN_FILE);
        ProductTransaction transaction;
        try {
            transaction = ProductTransaction.of(partLine[Setting.INDEX_FOR_OPERATION],
                    partLine[Setting.INDEX_FOR_PRODUCT], partLine[Setting.INDEX_FOR_QUANTITY]);
        } catch (RuntimeException e) {
            throw new TransactionParsingStringException(
                    String.format("Error parse input line '%s'", line));
        }
        return transaction;
    }
}
