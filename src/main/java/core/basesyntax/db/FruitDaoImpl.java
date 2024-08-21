package core.basesyntax.db;

import java.util.HashMap;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private final Map<String, Integer> fruitDB;

    public FruitDaoImpl() {
        fruitDB = new HashMap<>();
    }

    @Override
    public Integer putFruits(String key, Integer value) {
        Integer numberOfFruits = fruitDB.get(key);

        validateValue(numberOfFruits, value);
        if (numberOfFruits == null) {
            return fruitDB.put(key, value);
        }
        return fruitDB.put(key, numberOfFruits + value);
    }

    public Map<String, Integer> getFruitDB() {
        return new HashMap<>(fruitDB);
    }

    private void validateValue(Integer numberOfFruits, Integer value) {
        if (numberOfFruits == null && value < 0
                || numberOfFruits != null && numberOfFruits + value < 0) {
            throw new RuntimeException("Fruit stock cannot be less than 0");
        }
    }

}
