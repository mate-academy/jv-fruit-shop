package core.basesyntax.service.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.operation.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private Storage storage;
    private FruitService fruitService;

    public PurchaseOperationHandler(Storage storage,FruitService fruitService) {

        this.storage = storage;
        this.fruitService = fruitService;
    }

    @Override
    public void apply(FruitTransactionDto dto) {
        int quantityFruitInStorage = storage.getFruitQuantity(dto.getNameFruit());
        if (quantityFruitInStorage - dto.getQuantity() < 0) {
            throw new RuntimeException("Quantity of " + dto.getNameFruit()
                    + " is not enough for this purchase");
        }
        int newFruitQuantity = quantityFruitInStorage - dto.getQuantity();
        fruitService.save(dto.getNameFruit(), newFruitQuantity);
    }
}

