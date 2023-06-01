package core.basesyntax.service.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final FruitService fruitService;

    public ReturnOperationHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        fruitService.add(fruitTransaction);
    }
}
