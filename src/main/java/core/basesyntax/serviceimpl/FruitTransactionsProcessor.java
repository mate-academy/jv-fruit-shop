package core.basesyntax.serviceimpl;

import core.basesyntax.service.TransactionsProcessor;
import core.basesyntax.strategy.OperationsStrategy;
import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public class FruitTransactionsProcessor implements TransactionsProcessor {
    private OperationsStrategy operationsStrategy;

    public FruitTransactionsProcessor(OperationsStrategy operationsStrategy) {
        this.operationsStrategy = operationsStrategy;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            operationsStrategy.performTransaction(fruitTransaction);
        }
    }
}
