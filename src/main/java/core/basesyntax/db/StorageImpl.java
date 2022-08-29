package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class StorageImpl implements Storage {
    private List<FruitTransaction> transactions;

    @Override
    public void set(List<FruitTransaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public List<FruitTransaction> get() {
        return transactions;
    }
}
