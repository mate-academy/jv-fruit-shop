package mate.academy.service.impl;

import java.util.List;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ProcessData;
import mate.academy.strategy.TransactionStrategy;

public class ProcessImpl implements ProcessData {
    @Override
    public void processTransactions(List<FruitTransaction> transactions,
                                    TransactionStrategy transactionStrategy) {
        for (FruitTransaction transaction : transactions) {
            transactionStrategy.get(transaction.getOperation()).handleTransaction(transaction);
        }
    }
}
