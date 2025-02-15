package core.basesyntax.operation;

import core.basesyntax.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
