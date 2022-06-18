package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageSupplyService;

public class StorageSupplyServiceImpl implements StorageSupplyService {

    @Override
    public void add(String fruit, Integer amount) {
        if (Storage.fruits.containsKey(fruit)) {
            Integer newAmount = Storage.fruits.get(fruit) + amount;
            Storage.fruits.put(fruit, newAmount);
        } else {
            Storage.fruits.put(fruit, amount);
        }
    }

    @Override
    public void subtract(String fruit, Integer amount) {
        if (Storage.fruits.containsKey(fruit)) {
            Storage.fruits.put(fruit, Storage.fruits.get(fruit) - amount);
        } else {
            Storage.fruits.put(fruit, amount);
        }
    }
}
