package service;

import java.util.List;
import java.util.Map;
import model.FruitOperation;
import model.FruitType;

public interface CalculateFruit {
    Map<FruitType, Integer> calculateFruit(List<FruitOperation> listFruitOperation);
}
