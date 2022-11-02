package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.QuantityService;
import java.util.Map;

public class QuantityServiceImpl implements QuantityService {
    private static final Map<Fruit, Integer> STORAGE = Storage.fruits;
    private Integer variable;

    @Override
    public void add(Fruit fruit, Integer quantity) {
        variable = STORAGE.containsKey(fruit)
                ? STORAGE.replace(fruit, STORAGE.get(fruit) + quantity) :
                STORAGE.put(fruit, quantity);
    }

    @Override
    public void subtract(Fruit fruit, Integer quantity) {
        variable = STORAGE.containsKey(fruit)
                ? STORAGE.replace(fruit, STORAGE.get(fruit) - quantity) :
                STORAGE.put(fruit, -quantity);
    }
}
