package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.Map;

public class FruitTransactionStrategyImpl implements FruitTransactionStrategy {
    private Map<Operation, FruitTransactionHandler> operationHandlersMap;

    public FruitTransactionStrategyImpl(Map<Operation, FruitTransactionHandler>
                                                operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public FruitTransactionHandler getHandler(FruitTransaction fruitTransaction) {
        return operationHandlersMap.get(fruitTransaction.getType());
    }
}
