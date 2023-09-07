package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class PurchaseServiceImpl implements OperationService {
    private Storage storage;

    public PurchaseServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        storage.subtract(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
