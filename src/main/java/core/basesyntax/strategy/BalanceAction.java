package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceAction implements Action {
    @Override
    public void action(FruitTransaction fruitTransaction) {
        Storage.storage.put(fruitTransaction.getNameOfObject(), fruitTransaction.getAmount());
    }
}
