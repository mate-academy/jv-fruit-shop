package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.ArrayList;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao {
    @Override
    public void addFruitsStorage(String stringListFruits) {
        Storage.fruitStorage.add(stringListFruits);
    }

    @Override
    public List<String> getAllFruits() {
        return new ArrayList<>(Storage.fruitStorage);
    }

}
