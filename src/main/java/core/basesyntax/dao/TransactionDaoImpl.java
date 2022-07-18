package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import java.util.List;

public class TransactionDaoImpl implements TransactionDao {
    @Override
    public List<Transaction> getAll() {
        return new TransactionDaoCsvImpl().getAll();
    }

    @Override
    public void add(Transaction transaction) {
        Storage.transactions.add(transaction);
    }

}
