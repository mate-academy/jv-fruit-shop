package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(Map<String, Integer> inventory, FruitTransaction transaction) {
        inventory.merge(transaction.getFruit(), transaction.getQuantity(), Integer::sum);
    }
}
