package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final Map<FruitTransaction.OperationType, OperationHandler> map =
            Map.of(FruitTransaction.OperationType.BALANCE, new BalanceSetOperationHandler(),
                    FruitTransaction.OperationType.SUPPLY, new AdditionOperationHandler(),
                    FruitTransaction.OperationType.RETURN, new AdditionOperationHandler(),
                    FruitTransaction.OperationType.PURCHASE, new SubtractionOperationHandler());

    @Override
    public OperationHandler getOperation(FruitTransaction.OperationType operationType) {
        return map.get(operationType);
    }
}
