package core.basesyntax.strategy.impl;

import core.basesyntax.db.StorageDao;
import core.basesyntax.strategy.TransactionProcessor;
import core.basesyntax.util.FruitTransaction;
import java.util.List;

public class TransactionStrategy implements TransactionProcessor {
    private final StorageDao storageDao;

    public TransactionStrategy(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    public void processTransactions(List<String> actions) {
        actions.forEach(s -> transactionStrategy(new FruitTransaction(s)));
    }

    void transactionStrategy(FruitTransaction fruitTransaction) {
        switch (fruitTransaction.getOperation()) {
            case BALANCE:
                saveBalanceToStorage(fruitTransaction);
                break;
            case PURCHASE:
                reduceFromStorage(fruitTransaction);
                break;
            case SUPPLY:
            case RETURN:
                addToStorage(fruitTransaction);
                break;
            default:
                throw new RuntimeException("No strategy for this case");
        }
    }

    void reduceFromStorage(FruitTransaction fruitTransaction) {
        Integer oldValue = storageDao.getValue(fruitTransaction.getFruitName());
        Integer newValue = oldValue - fruitTransaction.getValueOfFruit();
        storageDao.setValue(fruitTransaction.getFruitName(),
                newValue);
    }

    void addToStorage(FruitTransaction fruitTransaction) {
        Integer oldValue = storageDao.getValue(fruitTransaction.getFruitName());
        Integer newValue = oldValue + fruitTransaction.getValueOfFruit();
        storageDao.setValue(fruitTransaction.getFruitName(),
                newValue);
    }

    void saveBalanceToStorage(FruitTransaction fruitTransaction) {
        storageDao.add(fruitTransaction.getFruitName(),
                fruitTransaction.getValueOfFruit());
    }
}
