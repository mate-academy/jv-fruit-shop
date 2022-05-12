package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Operation;
import core.basesyntax.service.OperationStrategyService;
import java.util.List;

public class OperationImpl implements Operation {
    private final OperationStrategyService operationStrategyService;

    public OperationImpl(OperationStrategyService operationStrategyService) {
        this.operationStrategyService = operationStrategyService;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        if (fruitTransactions.isEmpty()) {
            throw new RuntimeException("Empty input");
        }
        fruitTransactions.forEach(i -> operationStrategyService
                .get(i.getOperation()).apply(i));
    }
}
