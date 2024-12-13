package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> inventory, FruitTransaction transaction) {
        inventory.put(transaction.getFruit(), transaction.getQuantity());
    }
}
