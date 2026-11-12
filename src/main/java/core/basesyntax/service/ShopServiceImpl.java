package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategyImpl operationStrategy) {
        if (operationStrategy == null) {
            throw new IllegalArgumentException("Processing strategy cannot be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("The list of transactions cannot be null.");
        }
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            OperationHandler handler = operationStrategy.get(operation);
            handler.apply(transaction);
        }
    }
}
