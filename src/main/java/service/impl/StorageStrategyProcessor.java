package service.impl;

import db.Storage;
import java.util.List;
import model.Transaction;
import service.StrategyProcessor;

public class StorageStrategyProcessor implements StrategyProcessor {

    private final Storage storage;

    public StorageStrategyProcessor(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void processTransactionStrategies(List<Transaction> transactionList) {
        for (Transaction f : transactionList) {
            f.getOperationStrategy().handleOperation(storage);
        }
    }
}
