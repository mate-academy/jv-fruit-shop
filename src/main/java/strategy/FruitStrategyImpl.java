package strategy;

import java.util.Map;
import model.FruitTransaction;
import operation.Operation;

public class FruitStrategyImpl implements FruitStrategy {
    private Map<FruitTransaction.Operation, Operation> operationOperationHandlerMap;

    public FruitStrategyImpl(
            Map<FruitTransaction.Operation, Operation> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public void proceed(FruitTransaction fruitTransaction) {
        System.out.println(operationOperationHandlerMap
                .get(fruitTransaction.getOperation()).proceed(fruitTransaction));
    }
}
