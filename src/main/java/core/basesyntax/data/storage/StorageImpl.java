package core.basesyntax.data.storage;

import core.basesyntax.model.FruitTransactionRow;
import java.util.List;

public class StorageImpl implements Storage<FruitTransactionRow> {
    private static List<FruitTransactionRow> transactions;

    @Override
    public List<FruitTransactionRow> getTransactionHistory() {
        return transactions;
    }

    @Override
    public List<FruitTransactionRow> updateTransactionHistory(List<FruitTransactionRow> updated) {
        var oldTransactions = transactions;
        transactions = updated;
        return oldTransactions;
    }
}
