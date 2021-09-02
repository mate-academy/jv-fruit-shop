package core.basesyntax.service;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.db.OperationsStorage;
import core.basesyntax.model.Operation;

public class AmountCalculatorImpl implements AmountCalculator {
    private final OperationStrategy operationStrategy;

    public AmountCalculatorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void calculate() {
        for (Operation operation : OperationsStorage.getOperationList()) {
            int amount = operationStrategy.get(operation.getType()).getAmount(operation);
            FruitStorage.fruitsWithAmount.put(operation.getFruit(), amount);
        }
    }
}
