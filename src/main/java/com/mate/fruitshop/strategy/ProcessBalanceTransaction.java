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
    public boolean process(Transaction transaction) {
        FruitEntry fruitEntry = dao.getEntryByFruitName(transaction.getFruitName());
        if (fruitEntry == null) {
            return dao.addFruitEntry(new FruitEntry(transaction.getFruitName(),
                    transaction.getQuantity()));
        }
        fruitEntry.setQuantity(fruitEntry.getQuantity() + transaction.getQuantity());
        return true;
    }
}
