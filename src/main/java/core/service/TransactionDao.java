package core.service;

import java.util.Map;

public interface TransactionDao {
    void set(String fruit, int quantity);
    
    void add(String fruit, int quantity);
    
    void subtract(String fruit, int quantity);

    Map<String, Integer> getAll();
}
