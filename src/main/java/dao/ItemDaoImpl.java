package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;
import model.Transaction;

public class ItemDaoImpl implements ItemDao {
    @Override
    public void insert(Transaction transaction) {
        if (transaction.getOperation() == Transaction.Operation.BALANCE) {
            Storage.items.put(transaction.getItem(), transaction.getQuantity());
        } else {
            update(transaction);
        }
    }

    @Override
    public Set<Map.Entry<String, Integer>> readAll() {
        return Storage.items.entrySet();
    }

    private void update(Transaction transaction) {
        int updatedQuantity = readQuantity(transaction.getItem()) + transaction.getQuantity();
        Storage.items.put(transaction.getItem(), updatedQuantity);
    }

    private int readQuantity(String item) {
        return Storage.items.get(item);
    }
}
