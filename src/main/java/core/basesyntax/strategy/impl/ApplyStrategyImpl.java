package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.ApplyStrategy;
import core.basesyntax.strategy.UnaryOperation;
import java.util.HashMap;
import java.util.Map;

public class ApplyStrategyImpl implements ApplyStrategy {
    private Map<FruitTransaction.Operation, UnaryOperation> strategy = new HashMap<>();

    public ApplyStrategyImpl() {
        strategy.put(FruitTransaction.Operation.BALANCE, new ApplyBalance());
        strategy.put(FruitTransaction.Operation.PURCHASE, new ApplyPurchase());
        strategy.put(FruitTransaction.Operation.RETURN, new ApplyReturn());
        strategy.put(FruitTransaction.Operation.SUPPLY, new ApplySupplay());
    }

    @Override
    public void process(FruitTransaction fruit) {
        strategy.entrySet().stream()
                .filter(s -> s.getKey() == fruit.getOperation())
                .forEach(e -> e.getValue().apply(fruit));
    }
}
