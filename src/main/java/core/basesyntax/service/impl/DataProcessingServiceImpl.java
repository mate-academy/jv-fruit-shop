package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.DataProcessingService;
import core.basesyntax.service.interfaces.TransactionStrategy;
import core.basesyntax.service.transaction.TransactionHandler;
import java.util.List;

public class DataProcessingServiceImpl implements DataProcessingService {
    private TransactionStrategy transactionStrategy;

    public DataProcessingServiceImpl(TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void processData(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            TransactionHandler handler = transactionStrategy.get(transaction.getOperation());
            handler.executeTransaction(transaction);
        }
    }
}
