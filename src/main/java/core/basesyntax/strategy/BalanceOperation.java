package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handle(FruitTransaction transaction, Map<String, Integer> inventory) {
        inventory.put(transaction.getFruit(), transaction.getQuantity());
    }
}
