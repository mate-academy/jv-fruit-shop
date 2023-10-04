package core.basesyntax.dao;

import static core.basesyntax.db.Storage.inputData;

import java.util.HashMap;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void put(String fruitName, int quantity) {
        inputData.put(fruitName, quantity);
    }

    @Override
    public int getByName(String fruitName) {
        return inputData.get(fruitName);
    }

    @Override
    public Map<String,Integer> getAll() {
        return new HashMap<>(inputData);
    }
}
