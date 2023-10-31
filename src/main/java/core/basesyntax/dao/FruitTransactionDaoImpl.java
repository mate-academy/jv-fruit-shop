package core.basesyntax.dao;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    @Override
    public void add(String fruit, int quantity) {
        FruitStorage.fruitQuantity.put(fruit, quantity);
    }

    @Override
    public void replace(String fruit, int quantity) {
        FruitStorage.fruitQuantity.replace(fruit, quantity);
    }

    @Override
    public Map<String, Integer> getALl() {
        return FruitStorage.fruitQuantity;
    }

    @Override
    public int get(String fruit) {
        return FruitStorage.fruitQuantity.get(fruit);
    }
}
