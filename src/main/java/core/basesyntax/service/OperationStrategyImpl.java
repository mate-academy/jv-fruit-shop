package core.basesyntax.service;

import core.basesyntax.operations.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<core.basesyntax.service.FruitTransaction.Operation, FruitTransaction> operations;
    private core.basesyntax.service.FruitTransaction fruitTransaction;

    public OperationStrategyImpl(Map<core.basesyntax.service.FruitTransaction.Operation, FruitTransaction> operations,
                                 core.basesyntax.service.FruitTransaction fruitTransaction) {
        this.operations = operations;
        this.fruitTransaction = fruitTransaction;
    }

    @Override
    public void getOperation(core.basesyntax.service.FruitTransaction.Operation operation) {
        operations.get(operation).execute(fruitTransaction);

    }
}
