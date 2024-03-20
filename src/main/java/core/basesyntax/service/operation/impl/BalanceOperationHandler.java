package core.basesyntax.service.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.operation.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private Storage storage;
    private FruitService fruitService;

    public BalanceOperationHandler(Storage storage,FruitService fruitService) {

        this.storage = storage;
        this.fruitService = fruitService;
    }

    @Override
    public void apply(FruitTransactionDto dto) {
        fruitService.manipulation(dto.getNameFruit(), dto.getQuantity());
    }

    @Override
    public boolean isApplicable(FruitTransactionDto dto) {
        return "b".equals(dto.getOperationType());
    }
}
