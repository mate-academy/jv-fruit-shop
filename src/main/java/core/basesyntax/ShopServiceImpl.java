package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    private final Map<String, Integer> fruitStock = new HashMap<>();

    @Override
    public void addFruit(String fruit, int quantity) {
        fruitStock.put(fruit, fruitStock.getOrDefault(fruit, 0) + quantity);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return fruitStock.getOrDefault(fruit, 0);
    }
}
