package core.basesyntax.dao.storage;

import java.util.Map;
import java.util.function.BiFunction;

public interface FruitStorageDao {
    Map<String, Integer> getAll();

    int getFruitQuantity(String key);

    int addFruitQuantity(String key, int value);

    int merge(String key, int value, BiFunction<Integer, Integer, Integer> remappingFunction);

    boolean isFruitInStorage(String fruitName);

    boolean hasSufficientFruitQuantity(String fruit, int quantity);
}
