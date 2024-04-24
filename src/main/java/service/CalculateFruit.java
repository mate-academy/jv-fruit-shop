package service;

import java.util.List;
import java.util.Map;
import model.FruitOperation;
import model.FruitOperationType;
import model.FruitType;

public interface CalculateFruit {
    Map<FruitType, Integer> calcualteFruit(List<FruitOperation> listFruitOperation);

    Integer calculateValue(FruitOperationType fruitOperationType,
                           FruitType fruitType, Integer value);
}
