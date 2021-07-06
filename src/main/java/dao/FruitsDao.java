package dao;

import exceptions.BalanceException;
import java.util.Map;
import models.Fruit;

public class FruitsDao implements GenericDao<Fruit, Integer> {

    @Override
    public void update(Fruit fruit, Integer quantity) {
        if (Storage.fruits.containsKey(fruit)) {
            if (Storage.fruits.get(fruit) + quantity >= 0) {
                Storage.fruits.put(fruit, Storage.fruits.get(fruit) + quantity);
                return;
            }
            throw new RuntimeException("Bad operation :(, it can't be that 0 > fruits");
        }
        if (quantity > 0) {
            Storage.fruits.put(fruit, quantity);
            return;
        }
        throw new BalanceException("Quantity can't be smaller then zero.");
    }

    @Override
    public Integer get(Fruit fruit) {
        if (Storage.fruits.containsKey(fruit)) {
            return Storage.fruits.get(fruit);
        }
        throw new BalanceException("There is no element like this :(");
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return Storage.fruits;
    }
}
