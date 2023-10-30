import model.FruitTransaction;

import java.util.List;

public class TransactionStorage {
    private final List<FruitTransaction> transactionList;

    public TransactionStorage(List<FruitTransaction> transactionList) {
        this.transactionList = transactionList;
    }
}
