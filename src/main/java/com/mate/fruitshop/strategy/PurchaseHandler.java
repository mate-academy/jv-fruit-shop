package com.mate.fruitshop.strategy;

import com.mate.fruitshop.dao.FruitStorageDao;
import com.mate.fruitshop.dao.impl.FruitStorageDaoImpl;
import com.mate.fruitshop.model.FruitEntry;
import com.mate.fruitshop.model.Transaction;

public class PurchaseHandler implements TransactionProcessingStrategy {
    private final FruitStorageDao dao;

    public PurchaseHandler() {
        this.dao = new FruitStorageDaoImpl();
    }

    @Override
    public void process(Transaction transaction) {
        FruitEntry fruitEntry = dao.getByName(transaction.getFruitName());
        if (fruitEntry == null || transaction.getQuantity() > fruitEntry.getQuantity()) {
            throw new RuntimeException("Purchase larger than available stock");
        }
        fruitEntry.setQuantity(fruitEntry.getQuantity() - transaction.getQuantity());
    }
}
