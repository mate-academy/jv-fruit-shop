package core.basesyntax.dao;

import core.basesyntax.db.Transactions;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class TransactionsDaoCsvImpl implements TransactionsDao {

    @Override
    public void addTransaction(FruitTransaction fruitTransaction) {
        Transactions.transactions
                .add(fruitTransaction);
    }

    @Override
    public List<FruitTransaction> getTransactions() {
        return Transactions.transactions;
    }
}

