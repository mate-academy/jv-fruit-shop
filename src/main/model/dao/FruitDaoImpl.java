package main.model.dao;

import main.model.Fruit;
import main.model.dto.FruitRecordDto;
import main.storage.FruitStorage;
import java.util.Map;

public class FruitDaoImpl implements FruitDao {
    @Override
    public void update(FruitRecordDto fruitRecord, int quantity) {
        FruitStorage.getFruits().put(new Fruit(fruitRecord.getName()), quantity);
    }

    @Override
    public Map<Fruit, Integer> getAll() {
        return FruitStorage.getFruits();
    }

    @Override
    public int getCurrentQuantity(FruitRecordDto fruitRecord) {
        Fruit fruit = new Fruit(fruitRecord.getName());
        return FruitStorage.getFruits().getOrDefault(fruit, 0);
    }
}
