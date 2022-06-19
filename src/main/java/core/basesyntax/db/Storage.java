package core.basesyntax.db;

import core.basesyntax.model.Transaction;
import java.util.List;

public class Storage {
    private final List<Transaction> transactions;

    public Storage(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
