package fruitshop.db;

import fruitshop.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionStorage {
    private static final List<FruitTransaction> storage = new ArrayList<>();

    public void add(FruitTransaction transaction) {
        storage.add(transaction);
    }

    public FruitTransaction get(int index) {
        return storage.get(index);
    }

    public int size() {
        return storage.size();
    }

    public List<FruitTransaction> getAll() {
        return storage;
    }
}
