package core.basesyntax.db;

import core.basesyntax.model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private List<Transaction> transactionsList;

    public Transactions() {
        transactionsList = new ArrayList<>();
    }

    public void registerTransaction(Transaction transaction) {
        transactionsList.add(transaction);
    }
}
