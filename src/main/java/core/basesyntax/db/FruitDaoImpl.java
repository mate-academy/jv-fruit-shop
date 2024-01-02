package core.basesyntax.db;

import core.basesyntax.exception.InvalidFruitDataException;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final int ZERO = 0;

    @Override
    public Integer getFruitBalance(String fruitName) {
        String fruitKey = fruitName.toLowerCase();

        return FruitDB.getFruitDataBase().getOrDefault(fruitKey, ZERO);
    }

    @Override
    public Integer addFruits(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        if (!FruitDB.getFruitDataBase().containsKey(fruitKey)) {
            FruitDB.getFruitDataBase().put(fruitKey, quantity);
        } else {
            FruitDB.getFruitDataBase().put(fruitKey, getFruitBalance(fruitKey) + quantity);
        }
        return getFruitBalance(fruitKey);
    }

    @Override
    public Integer subtractFruits(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        if (!FruitDB.getFruitDataBase().containsKey(fruitKey)) {
            throw new InvalidFruitDataException("There is no such fruit in the database: "
                    + fruitName);
        } else {
            return FruitDB.getFruitDataBase().put(fruitKey,
                    getFruitBalance(fruitKey) - quantity);
        }
    }

    @Override
    public Map<String, Integer> getDataBaseContent() {
        return FruitDB.getFruitDataBase();
    }
}
