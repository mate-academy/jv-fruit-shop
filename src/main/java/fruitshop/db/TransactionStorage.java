package fruitshop.db;

import fruitshop.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionStorage {
    private static final List<FruitTransaction> fruitTransactionList = new ArrayList<>();

    public void add(FruitTransaction transaction) {
        fruitTransactionList.add(transaction);
    }

    public FruitTransaction get(int index) {
        return fruitTransactionList.get(index);
    }

    public int size() {
        return fruitTransactionList.size();
    }

    public List<FruitTransaction> getAll() {
        return fruitTransactionList;
    }
}
