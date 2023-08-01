package core.basesyntax.strategy;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler getOperationHandler(FruitTransaction fruitTransaction,
                                Map<FruitTransaction.Operation, OperationHandler> mapOfHandler) {
        return mapOfHandler.get(fruitTransaction.getOperation());
    }
}
