package core.basesyntax.service.strategy;

import core.basesyntax.service.counter.OperationHandler;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<String, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<String, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler getOperationType(FruitTransaction fruitTransaction) {
        return handlersMap.get(fruitTransaction.getOperation().getCode());
    }
}
