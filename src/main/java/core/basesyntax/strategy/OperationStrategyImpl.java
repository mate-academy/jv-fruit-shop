package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    @Override
    public OperationHandler get(FruitTransaction.Operation operation,
                                Map<FruitTransaction.Operation, OperationHandler> map) {
        return map.get(operation);
    }
}
