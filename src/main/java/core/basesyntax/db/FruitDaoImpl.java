package core.basesyntax.db;

import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final int ZERO = 0;

    @Override
    public Integer setFruitBalance(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        return FruitDB.getFruitDataBase().put(fruitKey, quantity);
    }

    @Override
    public Integer getFruitBalance(String fruitName) {
        String fruitKey = fruitName.toLowerCase();

        return FruitDB.getFruitDataBase().getOrDefault(fruitKey, ZERO);
    }

    @Override
    public Integer addFruits(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        return FruitDB.getFruitDataBase().merge(fruitKey, quantity, Integer::sum);
    }

    @Override
    public Map<String, Integer> getDataBaseContent() {
        return FruitDB.getFruitDataBase();
    }
}
