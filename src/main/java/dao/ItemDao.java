package dao;

import model.Transaction;
import java.util.Map;
import java.util.Set;

public interface ItemDao {
    int getBalance(String item);
    void process(Transaction transaction);
    Set<Map.Entry<String, Integer>> getRecords();
}
