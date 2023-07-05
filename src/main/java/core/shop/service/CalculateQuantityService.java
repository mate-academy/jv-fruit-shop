package core.shop.service;

import core.shop.model.FruitRecord;
import java.util.List;

public interface CalculateQuantityService {
    int calculateQuantity(List<FruitRecord> fruitsList, String fruitName);
}
