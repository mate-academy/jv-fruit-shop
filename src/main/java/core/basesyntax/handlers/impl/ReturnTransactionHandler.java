package core.basesyntax.handlers.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.handlers.TransactionHandler;
import core.basesyntax.model.FruitTransaction;

public class ReturnTransactionHandler implements TransactionHandler{
    private final CommonSavingHandler commonSavingHandler;

    public ReturnTransactionHandler(StorageDao storageDao) {
        commonSavingHandler = new CommonSavingHandler(storageDao);
    }

    @Override
    public void process(FruitTransaction transaction) {
        commonSavingHandler.process(transaction);
    }
}
