package dao;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Fruit;

public class FruitShopDaoImpl implements FruitShopDao {
    @Override
    public void save(Fruit fruit) {
        Storage.fruits.put(fruit.getFruit(), fruit.getQuantity());
    }

    @Override
    public Integer getValue(Fruit fruit) {
        return Storage.fruits.get(fruit.getFruit());
    }

    @Override
    public List<Fruit> getAll() {
        List<Fruit> fruitList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            Fruit fruit = new Fruit();
            fruit.setFruit(entry.getKey());
            fruit.setQuantity(entry.getValue());
            fruitList.add(fruit);
        }
        return fruitList;
    }
}
