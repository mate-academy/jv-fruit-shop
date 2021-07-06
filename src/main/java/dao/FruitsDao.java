package dao;

import exceptions.BalanceException;
import java.util.HashMap;
import java.util.Map;
import models.Fruit;

public class FruitsDao implements GenericDao<Fruit, Integer> {
    private static final Map<Fruit, Integer> fruits = new HashMap<>();

    @Override
    public void update(Fruit fruit, Integer quantity) {
        if (fruits.containsKey(fruit)) {
            if (fruits.get(fruit) + quantity >= 0) {
                fruits.put(fruit, fruits.get(fruit) + quantity);
                return;
            }
            throw new RuntimeException("Bad operation :(, it can't be that 0 > fruits");
        }
        if (quantity > 0) {
            fruits.put(fruit, quantity);
            return;
        }
        throw new BalanceException("Quantity can't be smaller then zero.");
    }

    @Override
    public Integer get(Fruit fruit) {
        if (fruits.containsKey(fruit)) {
            return fruits.get(fruit);
        }
        throw new BalanceException("There is no element like this :(");
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return fruits;
    }
}
