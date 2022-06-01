package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.Map;

public class TransactionsDaoImpl implements TransactionsDao {
    @Override
    public void add(String fruit, Integer quantity) {
        Storage.fruitsInfo.put(fruit, quantity);
    }

    @Override
    public Map<String, Integer> get() {
        return Storage.fruitsInfo;
    }
}
