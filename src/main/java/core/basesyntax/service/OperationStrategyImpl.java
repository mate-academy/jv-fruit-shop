package core.basesyntax.service;

import core.basesyntax.service.operations.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void execute(FruitTransaction fruitTransaction, Map<String, Integer> fruitRepository) {
        operationHandlerMap.get(fruitTransaction.getOperation())
                .run(fruitTransaction, fruitRepository);
    }
}
