package core.basesyntax.db;

import java.util.Map;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getAll() {
        return FruitsStorage.getFruits();
    }

    @Override
    public Integer getQuantity(String fruitType) {
        return Optional.ofNullable(FruitsStorage.getFruits().get(fruitType))
                .orElse(0);
    }

    @Override
    public void add(String fruitType, int quantity) {
        FruitsStorage.getFruits().put(fruitType, quantity);
    }
}
