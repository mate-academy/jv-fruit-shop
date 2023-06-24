package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionHandler;
import core.basesyntax.str.OperationStrategy;
import java.util.List;

public class TransactionHandlerImpl implements TransactionHandler {
    private final OperationStrategy operationStrategy;

    public TransactionHandlerImpl(OperationStrategy operationStrategy) {

        this.operationStrategy = operationStrategy;
    }

    @Override
    public void parse(List<FruitTransaction> parseList) {
        for (FruitTransaction line : parseList) {
            operationStrategy.get(line.getOperation()).handle(line);
        }
    }
}
