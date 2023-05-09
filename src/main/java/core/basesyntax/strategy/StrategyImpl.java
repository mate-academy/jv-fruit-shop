package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.Operation, OperationHandler> hendlerMap;

    public StrategyImpl(Map hendlerMap) {
        this.hendlerMap = hendlerMap;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getHendlerMap() {
        return hendlerMap;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return hendlerMap.get(operation);
    }
}
