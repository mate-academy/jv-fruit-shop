package core.basesyntax.service;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.strategy.Strategy;
import java.util.List;

public class FruitShop {
    private final Strategy strategy;

    public FruitShop(Strategy strategy) {
        this.strategy = strategy;
    }

    public void processOfOperations(List<FruitsTransaction> operations) {
        for (FruitsTransaction operation : operations) {
            strategy.getOperationHandler(operation.getOperation())
                    .handleTransaction(operation);
        }
    }
}
