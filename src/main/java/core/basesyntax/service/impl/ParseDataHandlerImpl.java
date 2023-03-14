package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ParseDataHandlerImpl implements TransactionHandler {
    private final OperationStrategy operationStrategy;

    public ParseDataHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void parse(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            operationStrategy.get(transaction.getOperation()).action(transaction);
        }
    }
}
