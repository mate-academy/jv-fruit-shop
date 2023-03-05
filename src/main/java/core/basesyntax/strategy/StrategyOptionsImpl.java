package core.basesyntax.strategy;

import core.basesyntax.actions.DoingAction;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class StrategyOptionsImpl implements StrategyOptions {
    private final Map<FruitTransaction.Operation, DoingAction> strategy;

    public StrategyOptionsImpl(Map<FruitTransaction.Operation, DoingAction> strategy) {
        this.strategy = strategy;
    }

    @Override
    public DoingAction get(FruitTransaction.Operation type) {
        return strategy.get(type);
    }
}
