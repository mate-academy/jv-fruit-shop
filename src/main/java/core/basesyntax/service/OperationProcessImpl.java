package core.basesyntax.service;

import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class OperationProcessImpl implements OperationProcess {
    private final OperationStrategy operationStrategy;

    public OperationProcessImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            operationHandler.execute(fruitTransaction.getFruit().getName(),
                    fruitTransaction.getFruit().getQuantity());
        }
    }
}
