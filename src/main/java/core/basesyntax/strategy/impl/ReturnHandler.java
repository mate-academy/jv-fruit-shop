package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class ReturnHandler implements OperationHandler {
    private static final int MINIMUM_RETURN_AMOUNT = 1;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        int returnAmount = fruitTransaction.getQuantity();
        if (returnAmount < MINIMUM_RETURN_AMOUNT) {
            throw new RuntimeException(
                    "Balance-transaction quantity cannot be less than: "
                            + MINIMUM_RETURN_AMOUNT);
        }
        Map<String, Integer> storageMap = Storage.storageMap;
        String fruit = fruitTransaction.getFruit();
        int amountBeforeReturning = storageMap.get(fruit);
        storageMap.put(fruit, returnAmount + amountBeforeReturning);
    }
}
