package core.basesyntax.service.impl;

import core.basesyntax.exception.TransactionParsingStringException;
import core.basesyntax.model.ProductTransaction;
import core.basesyntax.service.ParseService;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParseServiceImpl implements ParseService {
    public static final String HEADER_IN_FILE = "type,fruit,quantity";
    public static final String FIELDS_DELIMITER = ",";
    public static final int INDEX_FOR_OPERATION = 0;
    public static final int INDEX_FOR_PRODUCT = 1;
    public static final int INDEX_FOR_QUANTITY = 2;

    @Override
    public Queue<ProductTransaction> parse(List<String> data) {
        Queue<ProductTransaction> transactionsQueue = new LinkedList<>();
        int lineCount = 0;
        for (String line : data) {
            if (lineCount++ == 0 && HEADER_IN_FILE.equalsIgnoreCase(line)) {
                continue;
            }
            String[] partsLine = line.split(FIELDS_DELIMITER);
            ProductTransaction transaction;
            try {
                transaction = ProductTransaction.of(
                        partsLine[INDEX_FOR_OPERATION],
                        partsLine[INDEX_FOR_PRODUCT],
                        partsLine[INDEX_FOR_QUANTITY]);
            } catch (RuntimeException e) {
                throw new TransactionParsingStringException(
                        String.format("Error parse input line '%s'", line));
            }
            transactionsQueue.add(transaction);
        }
        return transactionsQueue;
    }
}
