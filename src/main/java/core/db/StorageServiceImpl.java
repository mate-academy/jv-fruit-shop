package core.db;

import java.util.ArrayList;
import java.util.List;

public class StorageServiceImpl implements StorageService<FruitTransaction> {
    @Override
    public List<FruitTransaction> getAll() {
        return new ArrayList<>(Storage.transactions);
    }

    @Override
    public int setAll(List<FruitTransaction> transactions) {
        Storage.transactions = new ArrayList<>(transactions);
        return Storage.transactions.size();
    }

    @Override
    public boolean addTransaction(FruitTransaction transaction) {
        return Storage.transactions.add(transaction);
    }
}
