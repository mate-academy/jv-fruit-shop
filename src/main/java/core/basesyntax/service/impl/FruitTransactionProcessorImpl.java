package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.OperationStrategyService;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationStrategyService operationStrategyService;

    public FruitTransactionProcessorImpl(OperationStrategyService operationStrategyService) {
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
