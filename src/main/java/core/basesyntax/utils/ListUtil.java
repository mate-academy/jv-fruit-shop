package core.basesyntax.utils;

import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parser.TextLineParser;
import core.basesyntax.parser.impl.CsvTextLineParser;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class ListUtil {
    private static final int HEADER_INDEX = 0;
    private final TextLineParser parser = new CsvTextLineParser();

    public void processList(List<String> content, TransactionStrategy strategy) {
        content.remove(HEADER_INDEX);
        for (String line : content) {
            FruitTransaction transaction = parser.extractTransaction(line);
            if (transaction != null) {
                TransactionHandler transactionHandler = strategy.get(transaction.getOperation());
                transactionHandler.handle(transaction);
            }
        }
    }
}
