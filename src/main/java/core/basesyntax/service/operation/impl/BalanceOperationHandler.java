package core.basesyntax.service.operation.impl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private FruitService fruitService;

    public BalanceOperationHandler(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void apply(FruitTransactionDto dto) {
        fruitService.save(dto.getNameFruit(), dto.getQuantity());
    }
}
