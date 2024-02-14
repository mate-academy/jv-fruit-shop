package db;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class Storage {
    private final List<FruitTransaction> transactions = new ArrayList<>();

    public void createTransaction(FruitTransaction fruitTransaction) {
        transactions.add(fruitTransaction);
    }

    public List<FruitTransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<FruitTransaction> actionList) {
        transactions.addAll(actionList);
    }
}
