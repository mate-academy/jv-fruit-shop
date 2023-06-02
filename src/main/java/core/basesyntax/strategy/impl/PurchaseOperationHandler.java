package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.FruitService;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitService fruitService;

    public PurchaseOperationHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handler(Transaction transaction) {
        fruitService.remove(transaction);
    }
}
