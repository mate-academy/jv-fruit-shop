package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class BalanceOperation implements OperationHandler {
    @Override
    public void apply(FruitTransaction tx, Map<String, Integer> storage) {
        storage.put(tx.getFruit(), tx.getQuantity());
    }
}
