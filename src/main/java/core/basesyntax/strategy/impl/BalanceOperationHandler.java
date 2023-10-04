package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.FruitService;
import core.basesyntax.strategy.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final FruitService fruitService;

    public BalanceOperationHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handler(Transaction transaction) {
        fruitService.add(transaction);
    }
}
