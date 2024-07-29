package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {

    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> inventory) {
        inventory.put(transaction.getFruit(), transaction.getQuantity());
    }
}
