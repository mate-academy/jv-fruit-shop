package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class ProcessDataServiceImpl implements ProcessDataService {
    @Override
    public void processTransactions(List<FruitTransaction> transactions,
                                    TransactionStrategy transactionStrategy) {
        for (FruitTransaction transaction : transactions) {
            transactionStrategy.get(transaction.getOperation()).handleTransaction(transaction);
        }
    }
}
