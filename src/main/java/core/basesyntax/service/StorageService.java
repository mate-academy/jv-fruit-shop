package core.basesyntax.service;

import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.IFruitStrategy;
import java.util.ArrayList;
import java.util.List;

public class StorageService implements IStorageService {
    private final List<FruitTransaction> fruitTransactionList;
    private final IFruitStrategy<FruitTransaction> transaction;

    public StorageService() {
        fruitTransactionList = new ArrayList<>();
        transaction = new FruitStrategy<>();
    }

    @Override
    public boolean transaction(String operation, String fruit, Integer quantity) {
        FruitTransaction fruitTransaction;
        try {
            fruitTransaction = new FruitTransaction(operation, fruit, quantity);
            transaction.add(fruitTransaction);
            fruitTransactionList.add(fruitTransaction);
        } catch (NullPointerException e){
            return false;
        }
        return true;
    }
}
