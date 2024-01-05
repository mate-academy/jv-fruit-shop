package core.basesyntax.db;

import core.basesyntax.exception.InvalidFruitDataException;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    private static final int ZERO = 0;

    @Override
    public Integer setFruitBalance(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        return FruitDB.getFruitDataBase().merge(fruitKey, quantity, (oldV, newV) -> newV);
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
    public Integer subtractFruits(String fruitName, int quantity) {
        String fruitKey = fruitName.toLowerCase();

        if (!FruitDB.getFruitDataBase().containsKey(fruitKey)) {
            throw new InvalidFruitDataException("There is no such fruit in the database: "
                    + fruitName);
        } else {
            return FruitDB.getFruitDataBase()
                    .merge(fruitKey, quantity, (oldV, newV) -> oldV - newV);
        }
    }

    @Override
    public Map<String, Integer> getDataBaseContent() {
        return FruitDB.getFruitDataBase();
    }
}
