package core.basesyntax.service;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoCsvImpl;
import core.basesyntax.db.Storage;

public class BalanceFileReaderServiceImpl implements BalanceFileReaderService {
    private final TransactionDao transactionDao = new TransactionDaoCsvImpl();

    @Override
    public void getTransactionsFromFile() {
        Storage.transactions.addAll(transactionDao.getAll());
    }
}
