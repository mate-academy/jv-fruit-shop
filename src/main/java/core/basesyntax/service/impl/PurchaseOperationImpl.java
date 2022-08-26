package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.CalculateOperation;
import core.basesyntax.service.FruitService;

public class PurchaseOperationImpl implements CalculateOperation {
    private final FruitService fruitService;

    public PurchaseOperationImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void getCalculateFruit(FruitOperation fruitOperation) {
        fruitService.update(fruitOperation.getFruit(),
                fruitService.getAmount(fruitOperation.getFruit())
                        - fruitOperation.getAmount());
    }
}
