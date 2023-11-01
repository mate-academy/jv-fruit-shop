package core.basesyntax.service.performer;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class TransactionPerformerImpl implements TransactionPerformer {
    private final OperationStrategy operationStrategy;

    public TransactionPerformerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void performTransactions(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            OperationHandler operationHandler = operationStrategy
                    .findOperation(fruitTransaction.getOperation());
            operationHandler.operate(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }
    }
}
