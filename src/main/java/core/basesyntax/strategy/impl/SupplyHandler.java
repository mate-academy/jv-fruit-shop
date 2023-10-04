package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class SupplyHandler implements OperationHandler {
    private static final int MINIMUM_SUPPLY_AMOUNT = 1;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < MINIMUM_SUPPLY_AMOUNT) {
            throw new RuntimeException(
                    "Supply-transaction quantity cannot be less than: "
                            + MINIMUM_SUPPLY_AMOUNT);
        }
        Map<String, Integer> storageMap = Storage.storageMap;
        String fruit = fruitTransaction.getFruit();
        int amountInStorage = storageMap.get(fruit);
        storageMap.put(fruit, amountInStorage + fruitTransaction.getQuantity());
    }
}
