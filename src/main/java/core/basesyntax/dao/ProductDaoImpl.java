package core.basesyntax.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(Fruit fruit, int amount) {
        Storage.productStorage.put(fruit, amount);
    }

    @Override
    public List<String> getAll() {
        return Storage.productStorage
                .entrySet()
                .stream()
                .map(k -> {
                    String key = k.getKey().getFruitName();
                    Integer integer = k.getValue();
                    return key + "," + integer + System.lineSeparator();
                })
                .collect(Collectors.toList());
    }
}
