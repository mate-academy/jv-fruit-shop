package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.service.FruitShopService;

public class FruitShopServiceImpl implements FruitShopService {
    @Override
    public void addToStorage(FruitTransaction fruitTransaction,
                             Storage storage, OperationHandler operation) {
        operation.handle(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity(), storage);
    }
}
