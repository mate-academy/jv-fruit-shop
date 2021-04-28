package dao;

import db.Storage;
import exception.NoFruitsException;
import java.util.Map;
import java.util.Set;
import model.Fruit;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void add(Fruit fruit, Integer amount) {
        Storage.getFruits().put(fruit, amount);
    }

    @Override
    public Integer getAmount(Fruit fruit) {
        return Storage.getFruits().get(fruit);
    }

    @Override
    public Fruit get(String type) {
        return Storage.getFruits().keySet().stream()
                .filter(f -> f.getType().equals(type))
                .findFirst()
                .get();
    }

    @Override
    public void update(Fruit fruit, Integer amount) {
        Integer oldValue = Storage.getFruits().remove(fruit);
        if (oldValue == null) {
            throw new NoFruitsException("there are no " + fruit.getType() + " in this store");
        }
        add(fruit, amount);
    }

    @Override
    public Set<Map.Entry<Fruit, Integer>> getAll() {
        return Storage.getFruits().entrySet();
    }
}
