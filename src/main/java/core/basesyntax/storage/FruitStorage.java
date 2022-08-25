package core.basesyntax.storage;

import core.basesyntax.model.Fruit;
import java.util.HashMap;
import java.util.Map;

public class FruitStorage extends Storage<Fruit> implements Dao {
    public FruitStorage() {
        productBalance = new HashMap<>();
    }

    @Override
    public Map<Fruit, Integer> getBalance() {
        return Map.copyOf(productBalance);
    }

    @Override
    public int getAmount(Fruit fruit) {
        return productBalance.get(fruit);
    }

    @Override
    public void updateBalance(Fruit fruit, int amount) {
        productBalance.put(fruit, amount);
    }
}
