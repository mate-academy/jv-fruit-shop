package core.service.impl;

import core.model.FruitTransaction;
import core.service.TransactionHandler;
import core.strategy.OperationStrategy;
import core.strategy.OperationStrategyImpl;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private static final OperationStrategy strategy = new OperationStrategyImpl();

    @Override
    public void handle(List<FruitTransaction> parseList) {
        for (FruitTransaction line : parseList) {
            strategy.getOperationHandler(line.getOperation()).handle(line);
        }
    }
}
