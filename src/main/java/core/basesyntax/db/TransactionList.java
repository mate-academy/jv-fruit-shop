package core.basesyntax.db;

import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionList {
    private static List<Transaction> transactionList = new ArrayList<>();

    public static List<Transaction> getTransactionList() {
        return transactionList;
    }
}
