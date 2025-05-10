package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDb;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionProcessorService;

public class IncomingTransactionProcessorService implements TransactionProcessorService {
    private final FruitDb db;

    public IncomingTransactionProcessorService(FruitDb db) {
        this.db = db;
    }

    @Override
    public void process(Transaction transaction) {
        int quantity = db.getQuantity(transaction.getFruit()) + transaction.getQuantity();
        db.setQuantity(transaction.getFruit(), quantity);
    }
}
