package core.basesyntax.strategy.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class SupplyHandler implements OperationHandler {
    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        Incrementer.add(storage, transaction.getFruit(), transaction.getQuantity());
    }
}
