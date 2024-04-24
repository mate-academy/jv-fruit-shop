package core.basesyntax.strategy;

import core.basesyntax.Main;
import core.basesyntax.operation.Transaction;
import core.basesyntax.service.QuantityCounter;
import java.util.Map;

public class QuantityCounterStrategyImpl implements QuantityCounterStrategy {
    private Map<Transaction.Operation, QuantityCounter> quantityCounterMap = Main.get();

    @Override
    public QuantityCounter get(Transaction operation) {
        return quantityCounterMap.get(operation.getOperation());
    }
}
