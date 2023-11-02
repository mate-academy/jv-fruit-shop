package core.basesyntax.service.performer;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class PerformerImpl implements Performer {
    private OperationStrategy operationStrategy;

    public PerformerImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void performTransaction(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationStrategy.processOperation(fruitTransaction);
        }
    }
}
