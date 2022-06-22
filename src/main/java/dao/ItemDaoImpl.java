package dao;

import db.Storage;
import java.util.Map;
import java.util.Set;
import model.Transaction;

public class ItemDaoImpl implements ItemDao {

    @Override
    public int getBalance(String item) {
        return Storage.items.get(item);
    }

    @Override
    public void process(Transaction transaction) {
        int previousQuantity = transaction.getOperation() == Transaction.Operation.BALANCE
                ? 0 : getBalance(transaction.getItem());
        Storage.items.put(transaction.getItem(), previousQuantity + transaction.getQuantity());
    }

    @Override
    public Set<Map.Entry<String, Integer>> getRecords() {
        return Storage.items.entrySet();
    }
}
