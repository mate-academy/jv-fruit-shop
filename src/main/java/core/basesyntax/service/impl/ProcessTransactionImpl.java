package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessTransaction;
import core.basesyntax.strategy.TransactionStrategy;
import java.util.List;

public class ProcessTransactionImpl implements ProcessTransaction {
    private final StorageDao storageDao;
    private final TransactionStrategy transactionStrategy;

    public ProcessTransactionImpl(StorageDao storageDao, TransactionStrategy transactionStrategy) {
        this.storageDao = storageDao;
        this.transactionStrategy = transactionStrategy;
    }

    @Override
    public void addDataIntoStorage(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            Fruit fruit = fruitTransaction.getFruit();
            if (storageDao.getQuantity(fruit) == null) {
                storageDao.add(fruit, 0);
            }
            int newQuantity = transactionStrategy.get(fruitTransaction.getOperation())
                    .getBalance(storageDao.getQuantity(fruit), fruitTransaction.getQuantity());
            storageDao.add(fruit, newQuantity);
        }
    }
}
