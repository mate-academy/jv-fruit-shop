package core.basesyntax.daoimpl;

import core.basesyntax.dao.DaoTransactions;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.TransactionStorage;
import java.util.List;

public class DaoTransactionsImpl implements DaoTransactions {

    @Override
    public List<FruitTransaction> getFromTS() {
        return TransactionStorage.accessTS();
    }

    @Override
    public void addToStorage(FruitTransaction transaction) {
        TransactionStorage.accessTS().add(transaction);
    }

    @Override
    public void addToStorage(List<FruitTransaction> transactions) {
        TransactionStorage.accessTS().addAll(transactions);
    }

}
