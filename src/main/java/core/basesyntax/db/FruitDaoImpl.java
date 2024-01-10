package core.basesyntax.db;

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
