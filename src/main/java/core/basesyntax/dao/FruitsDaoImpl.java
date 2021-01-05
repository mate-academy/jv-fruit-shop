package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public void setData(List<Fruit> fruits) {
        Storage.data = fruits;
    }

    @Override
    public List<Fruit> getData() {
        return Storage.data == null ? new ArrayList<>() : Storage.data;
    }
}
