package dao;

import bd.LocalStorage;
import java.util.List;
import model.Fruit;

public class FruitDaoImpl implements FruitDao {
    @Override
    public List<Fruit> getListRemainder() {
        return LocalStorage.fruits;
    }

    @Override
    public void setFruit(Fruit fruit) {
        LocalStorage.fruits.add(fruit);
    }
}
