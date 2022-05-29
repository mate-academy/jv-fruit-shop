package dao;

import db.Storage;
import java.util.Map;

public class TransactionsDaoImpl implements TransactionsDao {
    @Override
    public void add(Map<String, Integer> inputMap) {
        Storage.transactions.putAll(inputMap);
    }

    @Override
    public Map<String, Integer> get() {
        return Storage.transactions;
    }
}
