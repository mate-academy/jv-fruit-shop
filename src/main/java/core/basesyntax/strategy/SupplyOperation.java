package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Integer currentQuantity = Storage.getFruitQuantity(fruitTransaction.getFruit());
        Storage.addFruitQuantity(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
