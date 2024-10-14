package database;

import java.util.Map;

public interface StorageDealer {
    void checkBalance(Map<String, Integer> transactions);

    void updateDatabase(Map<String, Integer> transactions);
}
