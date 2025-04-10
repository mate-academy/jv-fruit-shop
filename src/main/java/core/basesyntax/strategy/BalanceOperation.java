package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final Storage storage = Storage.getInstance();

    @Override
    public void warehouse(FruitTransaction fruitTransaction) {
        storage.updateFruitBalance(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
