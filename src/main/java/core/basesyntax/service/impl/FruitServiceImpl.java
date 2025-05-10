package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationStrategySupplier;
import core.basesyntax.service.operation.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private final OperationStrategySupplier supplier;

    public FruitServiceImpl(OperationStrategySupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public void performFruitsOperations(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationStrategy operation = supplier.get(transaction.getOperation());
            operation.performOperation(transaction);
        }
    }
}
