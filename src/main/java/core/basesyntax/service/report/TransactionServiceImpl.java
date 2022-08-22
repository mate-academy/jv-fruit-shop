package core.basesyntax.service.report;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction fruit : transactions) {
            operationStrategy.get(fruit.getOperation()).handle(fruit);
        }
    }
}
