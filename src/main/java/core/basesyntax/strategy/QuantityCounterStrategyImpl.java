package core.basesyntax.strategy;

import core.basesyntax.service.QuantityCounter;
import core.basesyntax.transaction.Transaction;
import java.util.Map;

public class QuantityCounterStrategyImpl implements QuantityCounterStrategy {
    private final Map<Transaction.Operation, QuantityCounter> quantityCounters;

    public QuantityCounterStrategyImpl(Map<Transaction.Operation,
            QuantityCounter> quantityCounters) {
        this.quantityCounters = quantityCounters;
    }

    @Override
    public QuantityCounter get(Transaction operation) {
        return quantityCounters.get(operation.getOperation());
    }
}
