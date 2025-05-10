package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class FruitShopStorage implements ShopStorage<Fruit> {
    private static final String STORAGE_VALUE_ERROR = "Storage value cannot be negative";
    private final Map<Fruit, Integer> fruitStorage = new EnumMap<>(Fruit.class);

    @Override
    public int getAmount(Fruit fruit) {
        return fruitStorage.get(fruit);
    }

    @Override
    public void save(Fruit fruit, int value, OperationType operationType) {
        fruitStorage.compute(fruit, (k, oldValue) -> validateCalculation(
                operationType.getFunction().applyAsInt(oldValue == null ? 0 : oldValue, value)));
    }

    @Override
    public Set<Fruit> getAllItems() {
        return fruitStorage.keySet();
    }

    private int validateCalculation(int result) {
        if (result < 0) {
            throw new RuntimeException(STORAGE_VALUE_ERROR);
        }
        return result;
    }
}
