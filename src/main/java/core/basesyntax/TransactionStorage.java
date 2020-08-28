package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class TransactionStorage {
    public List<FruitTransaction> fruitTransactions = new ArrayList<>();

    public void addAll(List<FruitTransaction> transactionList) {
        fruitTransactions.addAll(transactionList);
    }
}
