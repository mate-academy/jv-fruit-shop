package core.basesyntax.service.report;

import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.List;

public class TransactionProcessorImpl implements TransactionProcessor {

    private OperationStrategy countStrategy;

    public TransactionProcessorImpl(OperationStrategy countStrategy) {
        this.countStrategy = countStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            countStrategy.getOperationType(fruitTransaction).handle(fruitTransaction);
        }
    }
}
