package core.basesyntax.strategy.activity;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceActivity implements ActivityHandler {
    @Override
    public void doActivity(FruitTransaction fruitTransaction) {
        Storage.fruits.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}
