package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReceiveHandler;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.OperationType, OperationHandler> map = Stream.of(
            Map.entry(FruitTransaction.OperationType.BALANCE, new BalanceHandler()),
            Map.entry(FruitTransaction.OperationType.RETURN, new ReceiveHandler()),
            Map.entry(FruitTransaction.OperationType.PURCHASE, new PurchaseHandler()),
            Map.entry(FruitTransaction.OperationType.SUPPLY, new ReceiveHandler())
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    @Override
    public OperationHandler get(FruitTransaction.OperationType operation) {
        return map.get(operation);
    }
}
