package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.FruitOperation;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<FruitTransaction.Operation, FruitOperation> handlerMap;

    public StrategyImpl(Map<FruitTransaction.Operation, FruitOperation> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public FruitOperation get(FruitTransaction.Operation operation) {
        return handlerMap.get(operation);
    }
}
