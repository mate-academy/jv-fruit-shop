package core.basesyntax.service.impl;

import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parser.impl.CsvTextLineParser;
import core.basesyntax.service.ListProcessService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class ListProcessServiceImpl implements ListProcessService {
    private static final int HEADER_INDEX = 0;

    @Override
    public void processList(List<String> content, TransactionStrategy strategy) {
        content.remove(HEADER_INDEX);
        for (String line : content) {
            FruitTransaction transaction = new CsvTextLineParser().extractTransaction(line);
            if (transaction != null) {
                TransactionHandler transactionHandler = strategy.get(transaction.getOperation());
                transactionHandler.process(transaction);
            }
        }
    }
}
