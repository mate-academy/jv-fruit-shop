package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.exception.FruitStoreException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.UnaryOperation;

public class ApplyPurchase implements UnaryOperation {
    @Override
    public void apply(FruitTransaction fruit) {
        if (!Storage.storage.containsKey(fruit.getFruit())
                || Storage.storage.get(fruit.getFruit()).intValue() < fruit.getQuantity()) {
            throw new FruitStoreException("Can't selling " + fruit.getFruit()
                    + " the quantity of which is less or absent on the balance than in query");
        }
        Storage.storage.put(fruit.getFruit(),
                        Storage.storage.get(fruit.getFruit()).intValue() - fruit.getQuantity());
    }
}
