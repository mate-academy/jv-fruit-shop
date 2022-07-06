package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.List;
import java.util.stream.Collectors;

public class FruitShopDaoImpl implements FruitShopDao {

    @Override
    public void put(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public Integer get(String fruit) {
        return Storage.fruits.get(fruit);
    }

    @Override
    public List<String> getAll() {
        return Storage.fruits.entrySet().stream()
                .map(f -> f.getKey() + "," + f.getValue())
                .collect(Collectors.toList());
    }
}
