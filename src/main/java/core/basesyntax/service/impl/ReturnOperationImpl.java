package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.CalculateOperation;
import core.basesyntax.service.FruitService;

public class ReturnOperationImpl implements CalculateOperation {
    private final FruitService fruitService;

    public ReturnOperationImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void getCalculateFruit(FruitOperation fruitOperation) {
        fruitService.update(fruitOperation.getFruit(),fruitOperation.getAmount()
                + fruitService.getAmount(fruitOperation.getFruit()));
    }
}
