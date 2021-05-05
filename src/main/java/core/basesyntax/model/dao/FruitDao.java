package core.basesyntax.model.dao;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import java.util.Map;

public interface FruitDao {
    void update(FruitRecordDto fruitRecordDto, int quantity);

    Map<Fruit, Integer> getAll();

    int getCurrentQuantity(FruitRecordDto fruitRecordDto);
}
