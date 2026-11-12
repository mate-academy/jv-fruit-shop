package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.db.Storage;

public class ReturnOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction) {
        Storage.add(transaction.getFruit(), transaction.getQuantity());
    }
}
