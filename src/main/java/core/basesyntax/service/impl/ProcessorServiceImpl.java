package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessorService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ProcessorServiceImpl implements ProcessorService {
    private final OperationStrategy operationStrategy;

    public ProcessorServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> operationStrategy.get(transaction.getOperation())
                .operate(transaction));
    }
}
