package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationHandler;

public class BalanceOperationHandlerImpl implements OperationHandler {
    private final FruitService fruitService;

    public BalanceOperationHandlerImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitOperation fruitOperation) {
        fruitService.update(fruitOperation.getFruit(), fruitOperation.getAmount());
    }
}
