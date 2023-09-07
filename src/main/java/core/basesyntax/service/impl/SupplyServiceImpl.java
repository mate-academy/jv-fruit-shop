package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;

public class SupplyServiceImpl implements OperationService {
    private Storage storage;

    public SupplyServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void performOperation(FruitTransaction fruitTransaction) {
        storage.add(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
