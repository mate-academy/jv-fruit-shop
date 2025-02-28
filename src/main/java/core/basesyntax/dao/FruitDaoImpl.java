package core.basesyntax.dao;

import core.basesyntax.storage.Storage;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(String fruitName, int amount) {
        Storage.getFruitStorage().put(fruitName, amount);
    }

    @Override
    public void add(String fruitName, int amount) {
        Storage.getFruitStorage().compute(fruitName, (k, amountInStorage) -> {
            return amountInStorage == null ? amount : amountInStorage + amount;
        });
    }

    @Override
    public void remove(String fruitName, int amount) {
        Storage.getFruitStorage().compute(fruitName, (k, amountInStorage) -> {
            return amountInStorage >= amount ? amountInStorage - amount : amountInStorage;
        });
    }

    @Override
    public Map<String, Integer> getFruit(String fruitName) {
        return Storage.getFruitStorage().entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(fruitName))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    @Override
    public Map<String, Integer> getBalanceInStock() {
        return Storage.getFruitStorage();
    }
}
