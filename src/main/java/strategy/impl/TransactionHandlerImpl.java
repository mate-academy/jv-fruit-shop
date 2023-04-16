package strategy.impl;

import java.util.List;
import model.FruitTransaction;
import strategy.OperationStrategy;
import strategy.TransactionHandler;

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
