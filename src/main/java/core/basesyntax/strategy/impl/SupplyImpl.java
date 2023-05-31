package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.FruitHandler;

public class SupplyImpl implements FruitHandler {
    @Override
    public void calculateFruitOperation(FruitTransaction fruitTransaction) {
        if (Storage.fruitStorage.containsKey(fruitTransaction.getFruit())
                && fruitTransaction.getQuantity() >= 0) {
            Storage.fruitStorage.computeIfPresent(fruitTransaction.getFruit(),
                    (key, value) -> value + fruitTransaction.getQuantity());
        } else {
            throw new RuntimeException(
                    String.format("Key: %s is no valid or Quantity must be positive: %s",
                            fruitTransaction.getFruit(), fruitTransaction.getQuantity())
            );
        }
    }
}
