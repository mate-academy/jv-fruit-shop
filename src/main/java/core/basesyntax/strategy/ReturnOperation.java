package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final Storage storage;

    public ReturnOperation(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void warehouse(FruitTransaction fruitTransaction) {
        int current = storage.getFruitBalance(fruitTransaction.getFruit());
        storage.setFruitBalance(fruitTransaction.getFruit(), current
                + fruitTransaction.getQuantity());
    }
}
