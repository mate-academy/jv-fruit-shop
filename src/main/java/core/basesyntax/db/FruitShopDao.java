package core.basesyntax.db;

import java.util.List;

public interface FruitShopDao {
    int storageSize();
    List<String> getKeyAndValue();
    void put (String fruit, int quantity);
    void putOnlyFruits(String fruit);
}
