package core.basesyntax.db;

import java.util.Map.Entry;
import java.util.Set;

public interface Dao {
    boolean addEntry(String fruitName, int quantity);

    boolean removeEntry(String fruitName);

    boolean isStorageEmpty();

    boolean isFruitPresent(String fruitName);

    int getFruitQuantity(String fruitName);

    Set<Entry<String, Integer>> getAllEntries();
}
