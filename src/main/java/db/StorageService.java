package db;

import java.util.Map;

public interface StorageService {

    Map<String, Integer> getStorageCopy();

    Integer put(String fruit, int quantity);

    int get(String fruit);
}
