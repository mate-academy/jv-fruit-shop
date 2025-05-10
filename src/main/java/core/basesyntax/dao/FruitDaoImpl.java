package core.basesyntax.dao;

import core.basesyntax.db.FruitDatabase;
import java.util.Optional;

public class FruitDaoImpl implements FruitDao {
    @Override
    public Optional<Integer> getFruitQuantityByName(String name) {
        Integer quantity = FruitDatabase.database.get(name);
        return Optional.ofNullable(quantity);
    }

    @Override
    public void addFruitQuantity(String name, Integer quantity) {
        FruitDatabase.database.merge(name, quantity, Integer::sum);
    }

    @Override
    public void subtractFruitQuantity(String name, Integer quantity) {
        FruitDatabase.database.merge(name, quantity, (oldVal, newVal) -> oldVal - newVal);
    }
}
