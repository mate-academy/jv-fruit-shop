package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShop;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operations.OperationHandler;
import java.util.List;

public class FruitShopImpl implements FruitShop {
    private final OperationStrategy operationStrategy;

    public FruitShopImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            operationHandler.handle(transaction);
        }
    }
}
