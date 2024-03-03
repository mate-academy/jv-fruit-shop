package core.basesyntax.service.impl;

import core.basesyntax.dao.StoreCsvDao;
import core.basesyntax.entity.FruitTransaction;
import core.basesyntax.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
    StoreCsvDao storeCsvDao;

    TransactionServiceImpl(StoreCsvDao storeCsvDao) {
        this.storeCsvDao = storeCsvDao;
    }
    @Override
    public void writeTransactionToFile(FruitTransaction fruitTransaction) {
        storeCsvDao.add(fruitTransaction);
    }
}
