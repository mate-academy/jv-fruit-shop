package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.List;
import java.util.Map;

public class ProcessDataServiceImpl implements ProcessDataService {

    @Override
    public void processData(List<Transaction> transactions,
                            Map<Operation, OperationHandler> operationsMap) {
        OperationStrategy strategy = new OperationStrategyImpl(operationsMap);
        for (Transaction transaction : transactions) {
            OperationHandler handler = strategy.getOperation(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
