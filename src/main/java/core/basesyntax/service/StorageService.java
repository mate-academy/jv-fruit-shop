package core.basesyntax.service;

import core.basesyntax.strategy.ITransactionsHandler;
import java.util.ArrayList;
import java.util.List;

public class StorageService implements IStorageService {
    private List<FruitTransaction> fruitTransactionList;
    private ITransactionsHandler<FruitTransaction> transaction;

    public StorageService() {
        fruitTransactionList = new ArrayList<>();
    }

    @Override
    public boolean transaction(String operation, String fruit, Integer quantity) {
        return transaction.handle(new FruitTransaction(operation, fruit, quantity));
    }
}
