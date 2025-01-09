package core.basesyntax.impl;

import core.basesyntax.handler.BalanceHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.PurchaseHandler;
import core.basesyntax.handler.ReturnHandler;
import core.basesyntax.handler.SupplyHandler;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.transactor.Operation;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationStrategyImpl implements Strategy {
    private final Map<Operation,
            OperationHandler> map = Stream.of(Map.entry(Operation.BALANCE, new BalanceHandler()),
                    Map.entry(Operation.RETURN, new ReturnHandler()),
                    Map.entry(Operation.PURCHASE, new PurchaseHandler()),
                    Map.entry(Operation.SUPPLY, new SupplyHandler()))
            .collect(Collectors.toMap(Map.Entry:: getKey, Map.Entry:: getValue));

    @Override
    public OperationHandler get(Operation operation) {
        return map.get(operation);
    }
}
