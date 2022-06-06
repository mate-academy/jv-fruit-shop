package core.basesyntax.service;

import core.basesyntax.exception.TransactionParsingStringException;
import core.basesyntax.model.ProductTransaction;
import core.basesyntax.model.Setting;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParseServiceImpl implements ParseService {
    @Override
    public Queue<ProductTransaction> parse(List<String> data) {
        Queue<ProductTransaction> transactionsQueue = new LinkedList<>();
        int lineCount = 0;
        for (String line : data) {
            if (lineCount++ == 0 && Setting.HEADER_FILE_INPUT.equalsIgnoreCase(line)) {
                continue;
            }
            String[] partLine = line.split(Setting.FIELDS_DELIMITER_IN_FILE);
            ProductTransaction transaction;
            try {
                transaction = ProductTransaction.of(partLine[Setting.INDEX_FOR_OPERATION],
                        partLine[Setting.INDEX_FOR_PRODUCT], partLine[Setting.INDEX_FOR_QUANTITY]);
            } catch (RuntimeException e) {
                throw new TransactionParsingStringException(
                        String.format("Error parse input line '%s'", line));
            }
            transactionsQueue.add(transaction);
        }
        return transactionsQueue;
    }
}
