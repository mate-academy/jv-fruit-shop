package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessTransactionService;
import core.basesyntax.strategy.TransactionStrategy;

public class ProcessTransactionServiceImpl implements ProcessTransactionService {
    @Override
    public Fruit addDataIntoStorage(FruitTransaction fruitTransaction,
                                    StorageDao storageDao,
                                    TransactionStrategy transactionStrategy) {
        Fruit fruit = fruitTransaction.getFruit();
        if (storageDao.getQuantity(fruit) == null) {
            storageDao.add(fruit, 0);
        }
        int newQuantity = transactionStrategy.get(fruitTransaction.getOperation())
                .getBalance(storageDao.getQuantity(fruit), fruitTransaction.getQuantity());
        storageDao.add(fruit, newQuantity);
        return fruit;
    }
}
