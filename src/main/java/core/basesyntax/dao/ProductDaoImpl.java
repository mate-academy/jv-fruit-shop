package core.basesyntax.dao;

import core.basesyntax.model.Product;
import core.basesyntax.storage.Storage;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductDaoImpl implements ProductDao {
    @Override
    public void add(Product fruit, int amount) {
        Storage.productStorage.put(fruit, amount);
    }

    @Override
    public Optional<Integer> get(Product key) {
        return Optional.ofNullable(Storage.productStorage.get(key));
    }

    @Override
    public List<String> getAll() {
        return Storage.productStorage
                .entrySet()
                .stream()
                .map(entry -> entry.getKey().getFruitName() + "," + entry.getValue()
                        + System.lineSeparator())
                .collect(Collectors.toList());
    }
}
