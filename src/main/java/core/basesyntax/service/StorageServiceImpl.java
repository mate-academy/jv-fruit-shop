package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private OperationStrategy operationStrategy;

    public StorageServiceImpl(OperationStrategy transactionHandler) {
        this.operationStrategy = transactionHandler;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList) {
        for (int i = 0; i < fruitTransactionList.size(); i++) {
            operationStrategy.get(fruitTransactionList.get(i)
                    .getByCode()).addTransaction(fruitTransactionList.get(i));
        }
    }
}
