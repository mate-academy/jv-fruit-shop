package core.basesyntax.strategies;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.operationhandler.IOperationHandler;
import java.util.Map;

public class OperationStrategy implements IOperationStrategy {
    private final Map<FruitTransaction.Operation, IOperationHandler> operationHandlerMap;

    public OperationStrategy(
            Map<FruitTransaction.Operation,
                    IOperationHandler> operationHandlerMap
    ) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public IOperationHandler get(FruitTransaction.Operation operation) {
        return switch (operation) {
            case BALANCE -> operationHandlerMap.get(FruitTransaction.Operation.BALANCE);
            case SUPPLY -> operationHandlerMap.get(FruitTransaction.Operation.SUPPLY);
            case PURCHASE -> operationHandlerMap.get(FruitTransaction.Operation.PURCHASE);
            case RETURN -> operationHandlerMap.get(FruitTransaction.Operation.RETURN);
        };
    }
}
