package core.basesyntax.strategy;

import core.basesyntax.service.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;
import java.util.Map;

public class OperatioHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<FruitTransaction.TypeOperation, OperationHandler> listOperations;

    public OperatioHandlerStrategyImpl(Map<FruitTransaction.TypeOperation,
                                       OperationHandler> listOperations) {
        this.listOperations = listOperations;
    }

    @Override
    public OperationHandler chooseOperation(FruitTransaction.TypeOperation operation) {
        return listOperations.get(operation);
    }
}
