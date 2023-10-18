package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopService {
    private final OperationStrategy strategy;

    public FruitShopService(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    public void processOfOperations(List<FruitTransaction> operations) {
        for (FruitTransaction operation : operations) {
            strategy.getOperationHandler(operation.getOperation())
                    .handleTransaction(operation);
        }
    }
}
