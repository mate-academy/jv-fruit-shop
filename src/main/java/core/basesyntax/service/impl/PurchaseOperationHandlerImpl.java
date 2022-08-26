package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationHandler;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    private final FruitService fruitService;

    public PurchaseOperationHandlerImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void handle(FruitOperation fruitOperation) {
        fruitService.update(fruitOperation.getFruit(),
                fruitService.getAmount(fruitOperation.getFruit())
                        - fruitOperation.getAmount());
    }
}
