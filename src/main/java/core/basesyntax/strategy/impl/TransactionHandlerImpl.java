package core.basesyntax.strategy.impl;

import java.util.List;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.TransactionHandler;

public class TransactionHandlerImpl implements TransactionHandler {

    private final OperationStrategy operationStrategy;

    public TransactionHandlerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void parse(List<FruitTransaction> parseList) {
        for (FruitTransaction line : parseList) {
            operationStrategy.get(line.getOperation()).transaction(line);
        }
    }
}
