package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class StorageServiceImpl implements StorageService {
    private OperationStrategy operationStrategy;
    private FruitService fruitService;

    public StorageServiceImpl(OperationStrategy transactionHandler, FruitService fruitService) {
        this.operationStrategy = transactionHandler;
        this.fruitService = fruitService;
    }

    @Override
    public void processTransactions(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            operationStrategy.get(transaction.getByCode())
                    .handleTransaction(transaction, fruitService);
        }
    }
}
