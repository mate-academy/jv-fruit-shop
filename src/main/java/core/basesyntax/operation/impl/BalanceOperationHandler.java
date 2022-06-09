package core.basesyntax.operation.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.FruitService;

public class BalanceOperationHandler implements OperationHandler {
    private FruitService fruitService;

    public BalanceOperationHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitService.add(fruitTransaction);
    }
}
