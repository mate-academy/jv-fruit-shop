package mate.academy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mate.academy.db.Storage;
import mate.academy.model.Fruit;

public class FruitDaoImpl implements FruitDao {

    @Override
    public void add(Fruit fruit) {
        Storage.fruits.put(fruit.getFruit(), fruit);
    }

    @Override
    public Fruit get(String fruitName) {
        return Storage.fruits.get(fruitName);
    }

    @Override
    public List<Fruit> getList() {
        List<Fruit> fruitList = new ArrayList<>();
        for (Map.Entry<String, Fruit> entry : Storage.fruits.entrySet()) {
            fruitList.add(entry.getValue());
        }
        return fruitList;
    }
}
