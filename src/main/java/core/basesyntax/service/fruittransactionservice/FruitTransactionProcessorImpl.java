package core.basesyntax.service.fruittransactionservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private OperationStrategy operationStrategy;

    public FruitTransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void makeDailyFruitsUpdate(List<FruitTransaction> fruitTransactionList) {
        fruitTransactionList.forEach(t -> operationStrategy.getOperation(t.getOperation())
                .handle(t));
    }
}
