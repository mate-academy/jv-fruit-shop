package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void add(Fruit fruit) {
        Storage.fruitStorage.put(fruit.getName(), fruit.getQuantity());
    }

    @Override
    public Integer getByName(Fruit fruit) {
        return Storage.fruitStorage.get(fruit.getName());
    }

    @Override
    public List<Fruit> getFruitList() {
        List<Fruit> fruitList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            fruitList.add(new Fruit(entry.getKey(), entry.getValue()));
        }
        return fruitList;
    }
}
