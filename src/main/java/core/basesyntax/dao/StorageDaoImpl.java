package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Transaction;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public void add(Transaction transaction) {
        Storage.Transactions.add(transaction);
    }

    @Override
    public void addList(List<Transaction> transactions) {
        Storage.Transactions.addAll(transactions);
    }

    @Override
    public List<Transaction> getTransactions() {
        return Storage.Transactions;
    }
}
