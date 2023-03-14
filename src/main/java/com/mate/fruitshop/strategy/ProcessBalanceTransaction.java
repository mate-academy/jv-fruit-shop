package com.mate.fruitshop.strategy;

import com.mate.fruitshop.dao.FruitStorageDao;
import com.mate.fruitshop.dao.impl.FruitStorageDaoImpl;
import com.mate.fruitshop.model.FruitEntry;
import com.mate.fruitshop.model.Transaction;

public class ProcessBalanceTransaction implements TransactionProcessingStrategy {
    private final FruitStorageDao dao;

    public ProcessBalanceTransaction() {
        this.dao = new FruitStorageDaoImpl();
    }

    @Override
    public void process(Transaction transaction) {
        FruitEntry fruitEntry = dao.getByName(transaction.getFruitName());
        if (fruitEntry == null) {
            dao.add(new FruitEntry(transaction.getFruitName(),
                    transaction.getQuantity()));
            return;
        }
        fruitEntry.setQuantity(transaction.getQuantity());
    }
}
