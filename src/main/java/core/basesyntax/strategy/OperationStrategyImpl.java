package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationIstrategy;
import core.basesyntax.service.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private final OperationIstrategy operationIstrategy;

    public OperationStrategyImpl(OperationIstrategy operationIstrategy) {
        this.operationIstrategy = operationIstrategy;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationIstrategy.getHandlerByOperation(operation);
    }
}
