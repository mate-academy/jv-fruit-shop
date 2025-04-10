package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    private static Storage storage = Storage.getInstance();

    @Override
    public void warehouse(FruitTransaction fruitTransaction) {
        int current = storage.getFruitBalance(fruitTransaction.getFruit());
        storage.setFruitBalance(fruitTransaction.getFruit(), current
                + fruitTransaction.getQuantity());
    }
}
