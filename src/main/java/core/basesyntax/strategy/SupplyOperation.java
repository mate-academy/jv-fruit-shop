package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Integer currentQuantity = Storage.getFruitQuantity(fruitTransaction.getFruit());
        Storage.addFruitQuantity(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
