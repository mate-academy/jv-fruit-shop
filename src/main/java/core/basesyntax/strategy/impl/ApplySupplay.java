package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.UnaryOperation;

public class ApplySupplay implements UnaryOperation {
    @Override
    public void apply(FruitTransaction fruit) {
        if (Storage.storage.containsKey(fruit.getFruit())) {
            Storage.storage.put(fruit.getFruit(),
                    Storage.storage.get(fruit.getFruit()).intValue() + fruit.getQuantity());
        } else {
            Storage.storage.put(fruit.getFruit(),fruit.getQuantity());
        }
    }
}
