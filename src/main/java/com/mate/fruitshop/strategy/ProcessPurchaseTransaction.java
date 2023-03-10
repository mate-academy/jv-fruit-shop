package com.mate.fruitshop.strategy;

import com.mate.fruitshop.dao.FruitStorageDao;
import com.mate.fruitshop.dao.impl.FruitStorageDaoImpl;
import com.mate.fruitshop.model.FruitEntry;
import com.mate.fruitshop.model.Transaction;

public class ProcessPurchaseTransaction implements TransactionProcessingStrategy {
    private final FruitStorageDao dao;

    public ProcessPurchaseTransaction() {
        this.dao = new FruitStorageDaoImpl();
    }

    @Override
    public boolean process(Transaction transaction) {
        FruitEntry fruitEntry = dao.getEntryByFruitName(transaction.getFruitName());
        if (fruitEntry != null) {
            fruitEntry.setQuantity(fruitEntry.getQuantity() - transaction.getQuantity());
            return true;
        }
        return false;
    }
}
