package core.basesyntax.service.db;

import java.util.Map;

public interface StorageService {
    void updateBalance(String fruit, int quantity);

    void addSupply(String fruit, int quantity);

    void purchaseFruit(String fruit, int quantity);

    void returnFruit(String fruit, int quantity);

    Map<String, Integer> getStorage();
}
