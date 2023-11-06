package core.basesyntax.service.accountingreport;

import core.basesyntax.service.operation.FruitOperation;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {
    private OperationStrategy countStrategy;

    public TransactionProcessorImpl(OperationStrategy countStrategy) {
        this.countStrategy = countStrategy;
    }

    @Override
    public void process(List<FruitOperation> fruitTransactionList) {
        for (FruitOperation fruitOperation : fruitTransactionList) {
            countStrategy.getOperationType(fruitOperation).handle(fruitOperation);
        }
    }
}
