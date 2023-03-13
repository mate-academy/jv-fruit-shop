package com.mate.fruitshop.strategy;

import com.mate.fruitshop.dao.FruitStorageDao;
import com.mate.fruitshop.dao.impl.FruitStorageDaoImpl;
import com.mate.fruitshop.model.FruitEntry;
import com.mate.fruitshop.model.Transaction;

public class ProcessReturnTransaction implements TransactionProcessingStrategy {
    private final FruitStorageDao dao;

    public ProcessReturnTransaction() {
        this.dao = new FruitStorageDaoImpl();
    }

    @Override
    public void process(Transaction transaction) {
        FruitEntry fruitEntry = dao.getEntryByFruitName(transaction.getFruitName());
        if (fruitEntry == null) {
            dao.addFruitEntry(new FruitEntry(transaction.getFruitName(),
                    transaction.getQuantity()));
            return;
        }
        fruitEntry.setQuantity(fruitEntry.getQuantity() + transaction.getQuantity());
    }
}
