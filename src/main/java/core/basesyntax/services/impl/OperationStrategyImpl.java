package core.basesyntax.services.impl;

import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handlers.BalanceHandler;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.PurchaseHandler;
import core.basesyntax.strategy.handlers.ReceiveHandler;
import core.basesyntax.transactor.Operation;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> map = Stream.of(
            Map.entry(Operation.BALANCE, new BalanceHandler()),
            Map.entry(Operation.RETURN, new ReceiveHandler()),
            Map.entry(Operation.PURCHASE, new PurchaseHandler()),
            Map.entry(Operation.SUPPLY, new ReceiveHandler())
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    @Override
    public OperationHandler get(Operation operation) {
        return map.get(operation);
    }
}
