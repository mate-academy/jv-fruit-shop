package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationStrategy;
import core.basesyntax.strategy.impl.PurchaseOperationStrategy;
import core.basesyntax.strategy.impl.ReturnOperationStrategy;
import core.basesyntax.strategy.impl.SupplyOperationStrategy;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationStrategyImpl {
    private static Map<FruitTransaction.Operation, OperationStrategy> strategies = Stream.of(
            new AbstractMap.SimpleEntry<>(FruitTransaction.Operation.BALANCE,
                    new BalanceOperationStrategy()),
            new AbstractMap.SimpleEntry<>(FruitTransaction.Operation.PURCHASE,
                    new PurchaseOperationStrategy()),
            new AbstractMap.SimpleEntry<>(FruitTransaction.Operation.RETURN,
                    new ReturnOperationStrategy()),
            new AbstractMap.SimpleEntry<>(FruitTransaction.Operation.SUPPLY,
                    new SupplyOperationStrategy()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public OperationStrategy getOperationStrategy(FruitTransaction transaction) {
        return strategies.get(transaction.getOperation());
    }
}
