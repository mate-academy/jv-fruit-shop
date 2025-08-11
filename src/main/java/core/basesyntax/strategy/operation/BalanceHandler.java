package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        storage.put(transaction.getFruit(), transaction.getQuantity());
    }
}
