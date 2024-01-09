package core.basesyntax.db;

import core.basesyntax.exception.InvalidFruitDataException;
import java.util.Map;
import java.util.function.BiFunction;

public class FruitDaoImpl implements FruitDao {
    private static final int ZERO = 0;

    private static class SubtractQuantityFunction implements BiFunction<Integer, Integer, Integer> {
        @Override
        public Integer apply(Integer oldQuantity, Integer newQuantity) {
            return oldQuantity - newQuantity;
        }
    }

    private final SubtractQuantityFunction subtractFunction = new SubtractQuantityFunction();

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
                    .merge(fruitKey, quantity, subtractFunction);
        }
    }

    @Override
    public Map<String, Integer> getDataBaseContent() {
        return FruitDB.getFruitDataBase();
    }
}
