package core.basesyntax.strategy.impl;

import static core.basesyntax.servise.FruitTransaction.Operation.BALANCE;
import static core.basesyntax.servise.FruitTransaction.Operation.PURCHASE;
import static core.basesyntax.servise.FruitTransaction.Operation.RETURN;
import static core.basesyntax.servise.FruitTransaction.Operation.SUPPLY;

import core.basesyntax.servise.FruitTransaction;
import core.basesyntax.strategy.MapOfHandlersForStrategy;
import core.basesyntax.strategy.OperationService;
import java.util.HashMap;
import java.util.Map;

public class MapOfHandlersForStrategyImpl implements MapOfHandlersForStrategy {
    private static final Map<FruitTransaction.Operation, OperationService> handlers
            = new HashMap<>();

    public MapOfHandlersForStrategyImpl() {
        handlers.put(BALANCE, new BalanceOperationService());
        handlers.put(SUPPLY, new IncomingOperationService());
        handlers.put(RETURN, new IncomingOperationService());
        handlers.put(PURCHASE, new OutgoingOperationService());
    }

    @Override
    public Map<FruitTransaction.Operation, OperationService> getMap() {
        return handlers;
    }
}
