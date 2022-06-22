package dao;

import java.util.Map;
import java.util.Set;
import model.Transaction;

public interface ItemDao {
    void insert(Transaction transaction);

    Set<Map.Entry<String, Integer>> readAll();
}
