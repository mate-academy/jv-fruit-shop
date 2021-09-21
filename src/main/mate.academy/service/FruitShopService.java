package service;

import model.Fruit;
import model.FruitRecord;
import java.util.List;
import java.util.Map;

public interface FruitShopService {
    Map<Fruit, Integer> transfer(List<FruitRecord> transferFruitList, OperationStrategy operationStrategy);
}
