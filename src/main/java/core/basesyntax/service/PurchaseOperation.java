package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class PurchaseOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> inventory, FruitTransaction transaction) {
        inventory.merge(transaction.getFruit(), -transaction.getQuantity(),
                (currentQuantity, decrement) -> {
                    int updatedQuantity = currentQuantity + decrement;
                    if (updatedQuantity < 0) {
                        throw new IllegalArgumentException(
                                "Not enough inventory for purchase: "
                                        + transaction.getFruit());
                    }
                    return updatedQuantity;
                });
    }
}
