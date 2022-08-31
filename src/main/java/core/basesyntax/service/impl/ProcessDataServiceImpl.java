package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;

public class ProcessDataServiceImpl implements ProcessDataService {
    OperationStrategy strategy;

    public ProcessDataServiceImpl(OperationStrategy inputStrategy) {
         strategy = inputStrategy;
    }

    @Override
    public void processData(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OperationHandler handler = strategy.getOperation(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
