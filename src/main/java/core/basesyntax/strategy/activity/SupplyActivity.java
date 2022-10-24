package core.basesyntax.strategy.activity;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class SupplyActivity implements ActivityHandler {
    @Override
    public void doActivity(FruitTransaction fruitTransaction) {
        Integer currentQuantity = Storage.fruits.get(fruitTransaction.getFruit());
        Storage.fruits.put(fruitTransaction.getFruit(),
                currentQuantity + fruitTransaction.getQuantity());
    }
}
