package core.basesyntax.db;

import core.basesyntax.exception.InvalidFruitDataException;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final int ZERO = 0;

    @Override
    public Integer setFruitBalance(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        if (!FruitDB.getFruitDataBase().containsKey(fruitKey)) {
            addFruit(fruitKey, quantity);
        } else {
            FruitDB.getFruitDataBase().put(fruitKey, quantity);
        }
        return FruitDB.getFruitDataBase().get(fruitKey);
    }

    @Override
    public Integer addFruit(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        return FruitDB.getFruitDataBase().put(fruitKey, quantity);
    }

    @Override
    public Integer getFruitBalance(String fruitName) {
        String fruitKey = fruitName.toLowerCase();

        return FruitDB.getFruitDataBase().getOrDefault(fruitKey, ZERO);
    }

    @Override
    public Integer addFruitsToBalance(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        if (!FruitDB.getFruitDataBase().containsKey(fruitKey)) {
            addFruit(fruitKey, quantity);
        } else {
            FruitDB.getFruitDataBase().put(fruitKey, FruitDB.getFruitDataBase()
                    .get(fruitKey) + quantity);
        }
        return FruitDB.getFruitDataBase().get(fruitKey);
    }

    @Override
    public Integer getFruitsFromBalance(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        if (!FruitDB.getFruitDataBase().containsKey(fruitKey)) {
            throw new InvalidFruitDataException("There is no such fruit in the database: "
                    + fruitName);
        } else {
            return FruitDB.getFruitDataBase().put(fruitKey,
                    FruitDB.getFruitDataBase().get(fruitKey) - quantity);
        }
    }

    @Override
    public Map<String, Integer> getDataBaseContent() {
        return FruitDB.getFruitDataBase();
    }
}
