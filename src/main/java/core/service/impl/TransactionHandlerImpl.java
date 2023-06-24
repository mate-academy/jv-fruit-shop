package core.service.impl;

import core.model.FruitTransaction;
import core.service.TransactionHandler;
import core.strategy.OperationStrategy;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private final OperationStrategy strategy;

    public TransactionHandlerImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void handle(List<FruitTransaction> parseList) {
        for (FruitTransaction line : parseList) {
            strategy.getOperationHandler(line.getOperation()).handle(line);
        }
    }
}
