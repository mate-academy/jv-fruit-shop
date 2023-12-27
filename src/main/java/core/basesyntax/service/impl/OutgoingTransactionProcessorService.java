package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDB;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionProcessorService;

public class OutgoingTransactionProcessorService implements TransactionProcessorService {
    private final FruitDB db;

    public OutgoingTransactionProcessorService(FruitDB db) {
        this.db = db;
    }

    @Override
    public void process(Transaction transaction) {
        int quantity = db.getQuantity(transaction.getFruit()) - transaction.getQuantity();
        db.setQuantity(transaction.getFruit(), quantity);
    }
}
