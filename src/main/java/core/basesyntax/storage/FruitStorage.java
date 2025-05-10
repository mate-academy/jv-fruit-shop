package core.basesyntax.storage;

import java.util.Map;

public interface FruitStorage {
    void addFruit(String fruit, int quantity);

    void setFruitBalance(String fruit, int quantity);

    void removeFruit(String fruit, int quantity);

    int getFruitQuantity(String fruit);

    Map<String, Integer> getAllFruits();
}
