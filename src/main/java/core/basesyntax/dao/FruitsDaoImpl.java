package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

//
public class FruitsDaoImpl implements FruitsDao{

    @Override
    public boolean add(Fruit fruit) {
        Storage.fruits.add(fruit);
        return false;
    }

    @Override
    public Fruit get(String fruit) {
        return Storage.fruits.stream()
                .filter(e -> e.getType().equals(fruit))
                .findFirst()
                .get();
    }
}