package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        Integer currentQuantity = Storage.getFruitQuantity(fruitTransaction.getFruit());
        Storage.setFruitQuantity(fruitTransaction.getFruit(),
                currentQuantity + fruitTransaction.getQuantity());
    }
}
