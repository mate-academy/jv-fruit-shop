package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.math.BigDecimal;
import java.util.Map;

public class BalanceStrategy implements OperationStrategy {
    @Override
    public void apply(Map<String, BigDecimal> inventory, FruitTransaction transaction) {
        inventory.put(transaction.getFruit(), transaction.getQuantity());
    }
}
