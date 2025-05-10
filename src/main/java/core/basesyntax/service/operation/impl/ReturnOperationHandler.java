package core.basesyntax.service.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.operation.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private Storage storage;
    private FruitService fruitService;

    public ReturnOperationHandler(Storage storage,FruitService fruitService) {

        this.storage = storage;
        this.fruitService = fruitService;
    }

    @Override
    public void apply(FruitTransactionDto dto) {
        int newFruitQuantity = storage.getFruitQuantity(dto.getNameFruit()) + dto.getQuantity();
        fruitService.save(dto.getNameFruit(), newFruitQuantity);
    }
}
