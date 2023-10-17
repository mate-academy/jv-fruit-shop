package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.TransactionService;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class TransactionServiceImpl implements TransactionService {
    private Map<Operation, OperationHandler> operationStrategyMap;

    public TransactionServiceImpl(Map<Operation, OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void handleTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction: transactions) {
            operationStrategyMap
                    .get(transaction.getOperation())
                    .handle(transaction);
        }
    }
}
