package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;

public class ProcessDataServiceImpl implements ProcessDataService {
    @Override
    public void processData(List<Transaction> transactions,
                            OperationStrategy strategy) {
        for (Transaction transaction : transactions) {
            OperationHandler handler = strategy.getOperation(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
