package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.TransactionHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.Operation, TransactionHandler> map;

    public StrategyImpl(Map<FruitTransaction.Operation, TransactionHandler> map) {
        this.map = map;
    }

    @Override
    public TransactionHandler get(FruitTransaction.Operation key) {
        return map.get(key);
    }
}
