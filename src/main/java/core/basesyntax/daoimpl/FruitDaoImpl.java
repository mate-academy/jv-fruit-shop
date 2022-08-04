package core.basesyntax.daoimpl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.storage.FruitsStorage;
import java.util.Map;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Map<String, Integer> getAll() {
        return FruitsStorage.getFruits();
    }

    @Override
    public Integer getQuantity(String fruitType) {
        Optional<Integer> quantity =
                Optional.ofNullable(FruitsStorage.getFruits().get(fruitType));
        return quantity.orElse(0);
    }

    @Override
    public void add(String fruitType, int quantity) {
        FruitsStorage.getFruits().put(fruitType, quantity);
    }
}
