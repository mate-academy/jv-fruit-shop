package dao;

import java.util.Map;
import java.util.Set;
import model.Transaction;

public interface ItemDao {
    int getBalance(String item);

    void process(Transaction transaction);

    Set<Map.Entry<String, Integer>> getRecords();
}
