package main.model.dao;

import main.model.Fruit;
import main.model.dto.FruitRecordDto;
import java.util.Map;

public interface FruitDao {
    void update(FruitRecordDto fruitRecordDto, int quantity);
    Map<Fruit, Integer> getAll();
    int getCurrentQuantity(FruitRecordDto fruitRecordDto);
}
