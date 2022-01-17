package core.basesyntax.dao.impl;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.db.TransactionsData;
import core.basesyntax.model.Transaction;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public List<Transaction> get() {
        return TransactionsData.transactions;
    }
}
