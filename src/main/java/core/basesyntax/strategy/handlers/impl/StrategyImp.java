package core.basesyntax.strategy.handlers.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;
import core.basesyntax.strategy.handlers.Strategy;
import java.util.HashMap;
import java.util.Map;

public class StrategyImp implements Strategy {
    private Map<FruitTransaction.Operation, OperationHandler> hendlers = new HashMap<>();

    public StrategyImp(Map<FruitTransaction.Operation, OperationHandler> hendlers) {
        this.hendlers = hendlers;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction fruitTransaction) {
        return hendlers.get(fruitTransaction.getOperation());
    }
}
